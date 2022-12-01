package nz.gabe.backtester.api.event.events;

import nz.gabe.backtester.api.event.Event;
import nz.gabe.backtester.api.event.EventType;

public class MarketActEvent implements EventBase {

    public MarketActEvent() {}

    public String toJson() {
        return Event.toJson(EventType.MARKET_ACT, this);
    }
}
