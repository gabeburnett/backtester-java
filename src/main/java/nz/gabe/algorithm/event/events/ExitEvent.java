package nz.gabe.algorithm.event.events;

import nz.gabe.algorithm.event.EventType;
import nz.gabe.algorithm.event.Event;

public class ExitEvent implements EventBase {

    public ExitEvent() {}

    public String toJson() {
        return Event.toJson(EventType.EXIT, this);
    }
}
