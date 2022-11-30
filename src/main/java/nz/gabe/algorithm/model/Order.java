package nz.gabe.algorithm.model;

public class Order {

    private final long orderId;

    private final long symbolId;

    private final long createTime;

    private long transactTime;

    private final OrderType orderType;

    private OrderStatus orderStatus;

    private final boolean isBuySide;

    private final float quantity;

    private float filledQuantity;

    public Order(long orderId, long symbolId, long createTime, long transactTime, OrderType orderType, OrderStatus orderStatus, boolean isBuySide, float quantity, float filledQuantity) {
        this.orderId = orderId;
        this.symbolId = symbolId;
        this.createTime = createTime;
        this.transactTime = transactTime;
        this.orderType = orderType;
        this.orderStatus = orderStatus;
        this.isBuySide = isBuySide;
        this.quantity = quantity;
        this.filledQuantity = filledQuantity;
    }

    public long getOrderId() {
        return orderId;
    }

    public long getSymbolId() {
        return symbolId;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public boolean isBuySide() {
        return isBuySide;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public float getFilledQuantity() {
        return filledQuantity;
    }

    public float getQuantity() {
        return quantity;
    }

    public long getCreateTime() {
        return createTime;
    }

    public long getTransactTime() {
        return transactTime;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTransactTime(long transactTime) {
        this.transactTime = transactTime;
    }

    public void setFilledQuantity(float filledQuantity) {
        this.filledQuantity = filledQuantity;
    }

    public enum OrderType {
        MARKET
    }

    public enum OrderStatus {
        // The order has been accepted into the engine.
        NEW,
        // Part of the order or all of the order's quantity has filled.
        TRADE,
        // The order was canceled according to the order type's rules or by the exchange, (e.g. orders canceled during liquidation, orders canceled during maintenance)
        EXPIRED
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", symbolId=" + symbolId +
                ", createTime=" + createTime +
                ", transactTime=" + transactTime +
                ", orderType=" + orderType.toString() +
                ", orderStatus=" + orderStatus.toString() +
                ", isBuySide=" + isBuySide +
                ", quantity=" + quantity +
                ", filledQuantity=" + filledQuantity +
                '}';
    }
}