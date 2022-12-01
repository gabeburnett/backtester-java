package nz.gabe.backtester.api.event.events;

import nz.gabe.backtester.api.event.Event;
import nz.gabe.backtester.api.event.EventType;

public class ConnectionRequestEvent implements EventBase {

    private final long botId;

    public ConnectionRequestEvent(long botId) {
        this.botId = botId;
    }

    public long getBotId() {
        return botId;
    }

    public String toJson() {
        return Event.toJson(EventType.CONNECTION_REQUEST, this);
    }
}
