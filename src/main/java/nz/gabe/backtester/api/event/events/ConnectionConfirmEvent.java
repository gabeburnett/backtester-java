package nz.gabe.backtester.api.event.events;

import nz.gabe.backtester.api.event.Event;
import nz.gabe.backtester.api.event.EventType;
import nz.gabe.backtester.api.model.SymbolAssets;

public class ConnectionConfirmEvent implements EventBase {

    private final SymbolAssets symbolAssets;

    private final boolean marketAck;

    public ConnectionConfirmEvent(SymbolAssets symbolAssets, boolean marketAck) {
        this.symbolAssets = symbolAssets;
        this.marketAck = marketAck;
    }

    public boolean sendMarketAck() {
        return marketAck;
    }

    public SymbolAssets getSymbolAssets() {
        return symbolAssets;
    }

    public String toJson() {
        return Event.toJson(EventType.CONNECTION_CONFIRM, this);
    }
}
