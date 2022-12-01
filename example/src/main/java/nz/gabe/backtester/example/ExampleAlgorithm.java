package nz.gabe.backtester.example;

import com.google.gson.Gson;
import nz.gabe.backtester.api.AlgorithmBase;
import nz.gabe.backtester.api.event.EventHandler;
import nz.gabe.backtester.api.event.events.ActiveOrdersEvent;
import nz.gabe.backtester.api.event.events.BalanceEvent;
import nz.gabe.backtester.api.event.events.ConnectionConfirmEvent;
import nz.gabe.backtester.api.event.events.MarketTickEvent;
import nz.gabe.backtester.api.model.Balance;
import nz.gabe.backtester.api.model.OHLC;
import nz.gabe.backtester.api.model.Order;


import java.net.URI;
import java.util.List;

public class ExampleAlgorithm extends AlgorithmBase {

    List<Balance> balances;
    List<Order> orders;

    public ExampleAlgorithm(URI serverUri, long botId) {
        super(serverUri, botId);
        this.balances = null;
        this.orders = null;

        registerListener(this);
    }

    @EventHandler
    public void onConnectionConfirmEvent(ConnectionConfirmEvent event) {
        System.out.println("ConConfirm: " + new Gson().toJson(event.getSymbolAssets()));
        requestBalance();
        requestActiveOrders();
    }

    @EventHandler
    public void onBalance(BalanceEvent event) {
        balances = event.getBalances();
        System.out.println("BalanceEvent: " + new Gson().toJson(event.getBalances()));
    }

    @EventHandler
    public void onOrder(ActiveOrdersEvent event) {
        orders = event.getOrders();
        System.out.println("Active Orders: " + new Gson().toJson(event.getOrders()));
    }

    @EventHandler
    public void onMarketTickEvent(MarketTickEvent event) {
//        System.out.println("close!!: " + event.getOHLC().toString());
        OHLC ohlc = event.getOHLC();
        if (balances != null && orders != null && orders.size() == 0) {
            Balance sellAsset = balances.stream().filter(x -> x.getAsset().equalsIgnoreCase(getSymbolAssets().getSellAsset())).findFirst().get();
            createOrder(getSymbolAssets().getSymbolId(), Order.OrderType.MARKET, true, sellAsset.getAmount() * 0.1f);
        } else if (orders != null && orders.size() > 0) {
//            for (Order order : orders)
//                cancelOrder(getSymbolAssets().getSymbolId(), order.getOrderId());
        }
    }
}
