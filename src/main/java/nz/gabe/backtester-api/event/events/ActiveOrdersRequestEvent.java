package nz.gabe.algorithm.event.events;

import nz.gabe.algorithm.event.Event;
import nz.gabe.algorithm.event.EventType;

public class ActiveOrdersRequestEvent implements EventBase {

    public ActiveOrdersRequestEvent() {}

    public String toJson() {
        return Event.toJson(EventType.ACTIVE_ORDERS_REQUEST, this);
    }
}
