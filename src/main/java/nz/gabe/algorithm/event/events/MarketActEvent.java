package nz.gabe.algorithm.event.events;

import nz.gabe.algorithm.event.Event;
import nz.gabe.algorithm.event.EventType;

public class MarketActEvent implements EventBase {

    public MarketActEvent() {}

    public String toJson() {
        return Event.toJson(EventType.MARKET_ACT, this);
    }
}
