package nz.gabe.backtester.api.event.events;

import nz.gabe.backtester.api.event.Event;
import nz.gabe.backtester.api.event.EventType;

public class ActiveOrdersRequestEvent implements EventBase {

    public ActiveOrdersRequestEvent() {}

    public String toJson() {
        return Event.toJson(EventType.ACTIVE_ORDERS_REQUEST, this);
    }
}
