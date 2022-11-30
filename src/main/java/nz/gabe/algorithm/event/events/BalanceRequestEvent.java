package nz.gabe.algorithm.event.events;

import nz.gabe.algorithm.event.Event;
import nz.gabe.algorithm.event.EventType;

public class BalanceRequestEvent implements EventBase {

    public BalanceRequestEvent() {}

    public String toJson() {
        return Event.toJson(EventType.BALANCE_REQUEST, this);
    }
}
