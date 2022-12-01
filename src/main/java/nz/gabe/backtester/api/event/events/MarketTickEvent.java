package nz.gabe.backtester.api.event.events;

import nz.gabe.backtester.api.event.Event;
import nz.gabe.backtester.api.event.EventType;
import nz.gabe.backtester.api.model.OHLC;

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
