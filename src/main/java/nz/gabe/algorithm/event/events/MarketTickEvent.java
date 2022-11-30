package nz.gabe.algorithm.event.events;

import nz.gabe.algorithm.event.Event;
import nz.gabe.algorithm.event.EventType;
import nz.gabe.algorithm.model.OHLC;

public class MarketTickEvent implements EventBase {

    private final OHLC ohlc;

    public MarketTickEvent(OHLC ohlc) {
        this.ohlc = ohlc;
    }

    public OHLC getOHLC() {
        return ohlc;
    }

    public String toJson() {
        return Event.toJson(EventType.MARKET_TICK, this);
    }
}
