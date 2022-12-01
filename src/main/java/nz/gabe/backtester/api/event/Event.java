package nz.gabe.backtester.api.event;

import com.google.gson.Gson;

public class Event {

    private final EventType eventType;

    private final long eventTime;

    private final String data;

    public Event(EventType eventType, String data) {
        this.eventType = eventType;
        this.eventTime = System.currentTimeMillis();
        this.data = data;
    }

    public Event(EventType eventType, long eventTime, String data) {
        this.eventType = eventType;
        this.eventTime = eventTime;
        this.data = data;
    }

    public long getEventTime() {
        return eventTime;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getData() {
        return data;
    }

    private static final Gson gson = new Gson();

    public static String toJson(EventType eventType, Object obj) {
        Event eventContainer = new Event(eventType, gson.toJson(obj));
        return gson.toJson(eventContainer);
    }
}
