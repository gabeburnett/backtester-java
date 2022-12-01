package nz.gabe.backtester.api.event.events;

import nz.gabe.backtester.api.event.EventType;
import nz.gabe.backtester.api.event.Event;

public class ExitEvent implements EventBase {

    public ExitEvent() {}

    public String toJson() {
        return Event.toJson(EventType.EXIT, this);
    }
}
