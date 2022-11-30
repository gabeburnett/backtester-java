package nz.gabe.algorithm.event.events;

import nz.gabe.algorithm.event.Event;
import nz.gabe.algorithm.event.EventType;

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
