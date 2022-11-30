package nz.gabe.algorithm.event.events;

import nz.gabe.algorithm.event.Event;
import nz.gabe.algorithm.event.EventType;
import nz.gabe.algorithm.model.Order;

public class CreateOrderEvent implements EventBase {

    private final long symbolId;

    private final long timestamp;

    private final Order.OrderType orderType;

    private final boolean isBuySide;

    private final float quantity;

    public CreateOrderEvent(long symbolId, long timestamp, Order.OrderType orderType, boolean isBuySide, float quantity) {
        this.symbolId = symbolId;
        this.timestamp = timestamp;
        this.orderType = orderType;
        this.isBuySide = isBuySide;
        this.quantity = quantity;
    }

    public Order.OrderType getOrderType() {
        return orderType;
    }

    public float getQuantity() {
        return quantity;
    }

    public boolean isBuySide() {
        return isBuySide;
    }

    public long getSymbolId() {
        return symbolId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String toJson() {
        return Event.toJson(EventType.CREATE_ORDER, this);
    }
}
