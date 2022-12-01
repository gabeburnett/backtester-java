package nz.gabe.backtester.api.event.events;

import nz.gabe.backtester.api.event.Event;
import nz.gabe.backtester.api.event.EventType;

public class BalanceRequestEvent implements EventBase {

    public BalanceRequestEvent() {}

    public String toJson() {
        return Event.toJson(EventType.BALANCE_REQUEST, this);
    }
}
