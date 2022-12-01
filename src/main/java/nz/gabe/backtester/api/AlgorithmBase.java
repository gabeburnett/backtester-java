package nz.gabe.backtester.api;

import nz.gabe.backtester.api.event.events.ActiveOrdersRequestEvent;
import nz.gabe.backtester.api.event.events.BalanceRequestEvent;
import nz.gabe.backtester.api.event.events.CancelOrderEvent;
import nz.gabe.backtester.api.event.events.CreateOrderEvent;
import nz.gabe.backtester.api.model.OHLC;
import nz.gabe.backtester.api.model.Order;
import nz.gabe.backtester.api.model.SymbolAssets;

import java.net.URI;

public abstract class AlgorithmBase {

    private final AlgorithmSocket socket;

    private final long botId;
    private SymbolAssets symbolAssets;
    private boolean sendMarketAck;

    private OHLC currentKline;

    public AlgorithmBase(URI serverUri, long botId) {
        this.botId = botId;
        this.sendMarketAck = false;

        this.socket = new AlgorithmSocket(serverUri, this);
    }

    public long getBotId() {
        return botId;
    }

    void setSendMarketAck(boolean sendMarketAck) {
        this.sendMarketAck = sendMarketAck;
    }

    void setCurrentKline(OHLC currentKline) {
        this.currentKline = currentKline;
    }

    void setSymbolAssets(SymbolAssets symbolAssets) {
        this.symbolAssets = symbolAssets;
    }

    public SymbolAssets getSymbolAssets() {
        return symbolAssets;
    }

    boolean sendMarketAck() {
        return sendMarketAck;
    }

    public OHLC getCurrentKline() {
        return currentKline;
    }

    public void start() {
        socket.connect();
    }

    public void exit() {
        socket.exit();
    }

    public void registerListener(Object object) {
        socket.registerListener(object);
    }

    public void createOrder(long symbolId, Order.OrderType orderType, boolean isBuySide, float quantity) {
        System.out.println("Creating order");
        socket.sendEvent(new CreateOrderEvent(symbolId, System.currentTimeMillis(), orderType, isBuySide, quantity));
    }

    public void cancelOrder(long symbolId, long orderId) {
        socket.sendEvent(new CancelOrderEvent(symbolId, orderId));
    }

    public void requestActiveOrders() {
        socket.sendEvent(new ActiveOrdersRequestEvent());
    }

    public void requestBalance() {
        socket.sendEvent(new BalanceRequestEvent());
    }
}
