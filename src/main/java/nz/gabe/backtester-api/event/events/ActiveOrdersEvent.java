package nz.gabe.algorithm.event.events;

import nz.gabe.algorithm.event.Event;
import nz.gabe.algorithm.event.EventType;
import nz.gabe.algorithm.model.Order;

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
