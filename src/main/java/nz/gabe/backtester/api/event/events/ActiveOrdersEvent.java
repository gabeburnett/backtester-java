package nz.gabe.backtester.api.event.events;

import nz.gabe.backtester.api.event.Event;
import nz.gabe.backtester.api.event.EventType;
import nz.gabe.backtester.api.model.Order;

import java.util.List;

public class ActiveOrdersEvent implements EventBase {

    private final List<Order> orders;

    public ActiveOrdersEvent(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String toJson() {
        return Event.toJson(EventType.ACTIVE_ORDERS, this);
    }
}
