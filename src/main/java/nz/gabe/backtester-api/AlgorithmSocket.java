package nz.gabe.algorithm;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import nz.gabe.algorithm.event.Event;
import nz.gabe.algorithm.event.EventHandler;
import nz.gabe.algorithm.event.events.*;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class AlgorithmSocket extends WebSocketClient {

    private final Gson gson;
    private final AlgorithmBase algorithmBase;
    private final List<Object> listeners;

    public AlgorithmSocket(URI serverUri, AlgorithmBase algorithmBase) {
        super(serverUri);
        this.gson = new Gson();
        this.algorithmBase = algorithmBase;

        this.listeners = new ArrayList<>();
    }

    public void registerListener(Object object) {
        listeners.add(object);
    }

    @Override
    public void onOpen(ServerHandshake serverHandshake) {
        System.out.println("Connected to socket, getting algorithm details.");

        send(new ConnectionRequestEvent(algorithmBase.getBotId()).toJson());
    }

    private void callEventHandlers(Class eventClass, Object eventInstance) throws InvocationTargetException, IllegalAccessException {
        for (Object listener : listeners)
            for (Method method : listener.getClass().getMethods())
                if (method.isAnnotationPresent(EventHandler.class) && method.getParameterCount() == 1 && method.getParameterTypes()[0] == eventClass)
                    method.invoke(listener, eventInstance);
    }

    public void sendEvent(EventBase eventBase) {
        send(eventBase.toJson());
    }

    @Override
    public void onMessage(String s) {
        try {
            Event event = gson.fromJson(s, Event.class);

            switch (event.getEventType()) {
                case CONNECTION_CONFIRM -> {
                    ConnectionConfirmEvent confirmEvent = gson.fromJson(event.getData(), ConnectionConfirmEvent.class);
                    algorithmBase.setSendMarketAck(confirmEvent.sendMarketAck());
                    algorithmBase.setSymbolAssets(confirmEvent.getSymbolAssets());

                    callEventHandlers(ConnectionConfirmEvent.class, confirmEvent);

                    if (algorithmBase.sendMarketAck())
                        send(new MarketActEvent().toJson());
                }
                case MARKET_TICK -> {
                    MarketTickEvent tickEvent = gson.fromJson(event.getData(), MarketTickEvent.class);
                    algorithmBase.setCurrentKline(tickEvent.getOHLC());

                    callEventHandlers(MarketTickEvent.class, tickEvent);

                    if (algorithmBase.sendMarketAck())
                        send(new MarketActEvent().toJson());
                }
                case ACTIVE_ORDERS -> {
                    ActiveOrdersEvent ordersEvent = gson.fromJson(event.getData(), ActiveOrdersEvent.class);

                    callEventHandlers(ActiveOrdersEvent.class, ordersEvent);
                }
                case BALANCE -> {
                    BalanceEvent balanceEvent = gson.fromJson(event.getData(), BalanceEvent.class);

                    callEventHandlers(BalanceEvent.class, balanceEvent);
                }
                case EXIT -> close();
            }
        } catch (IllegalStateException | JsonSyntaxException e) {
            System.out.println("Invalid json: " + s);
        } catch (InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onClose(int i, String s, boolean b) {}

    @Override
    public void onError(Exception e) {
        e.printStackTrace();
    }

    public void exit() {
        send(new ExitEvent().toJson());
        close();
    }
}
