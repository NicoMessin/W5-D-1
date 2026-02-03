package niccolomessina.W5_D_1.entities;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderNumber;
    private OrderStatus status;
    private int seats;
    private LocalTime acquiredAt;
    private Table table;
    private List<Menu> items = new ArrayList<>();

    public Order(int orderNumber, Table table, int seats) {
        this.orderNumber = orderNumber;
        this.table = table;
        this.seats = seats;
        this.status = OrderStatus.IN_CORSO;
        this.acquiredAt = LocalTime.now();
    }

    public void addItem(Menu item) { items.add(item); }

    public double getTotal(double coverCharge) {
        double totalItems = 0.0;
        for (Menu m : items) totalItems += m.getPrezzo();
        return totalItems + (seats * coverCharge);
    }

    public int getOrderNumber() { return orderNumber; }
    public OrderStatus getStatus() { return status; }
    public int getSeats() { return seats; }
    public LocalTime getAcquiredAt() { return acquiredAt; }
    public Table getTable() { return table; }
    public List<Menu> getItems() { return items; }

    public void setStatus(OrderStatus status) { this.status = status; }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", status=" + status +
                ", seats=" + seats +
                ", acquiredAt=" + acquiredAt +
                ", table=" + table +
                ", items=" + items +
                '}';
    }
}
