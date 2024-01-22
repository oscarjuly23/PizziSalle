package model.order;

import model.User;
import model.pizzas.Delegacio;

import java.util.List;

public class Order {
    private int id;
    private User user;
    private Delegacio delegation;
    private List<OrderItem> orderItems;

    public Order(int id, User user, Delegacio delegation, List<OrderItem> orderItems) {
        this.id = id;
        this.user = user;
        this.delegation = delegation;
        this.orderItems = orderItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Delegacio getDelegation() {
        return delegation;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", delegation=" + delegation +
                ", orderItems=" + orderItems +
                '}';
    }
}
