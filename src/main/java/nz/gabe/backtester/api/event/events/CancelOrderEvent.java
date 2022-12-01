package nz.gabe.backtester.api.event.events;

import nz.gabe.backtester.api.event.Event;
import nz.gabe.backtester.api.event.EventType;

public class CancelOrderEvent implements EventBase {

    private final long symbolId;

    private final long orderId;

    public CancelOrderEvent(long symbolId, long orderId) {
        this.symbolId = symbolId;
        this.orderId = orderId;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getSymbolId() {
        return symbolId;
    }

    public String toJson() {
        return Event.toJson(EventType.CANCEL_ORDER, this);
    }
}
