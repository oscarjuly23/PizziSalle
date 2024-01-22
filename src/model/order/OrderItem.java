package model.order;

import model.pizzas.Beguda;
import model.pizzas.Massa;
import model.pizzas.Pizza;

public class OrderItem {
    private int id;
    private int quantity;
    private Pizza pizza;
    private Beguda beguda;
    private Massa massa;

    public OrderItem(int id, int quantity, Pizza pizza, Beguda beguda, Massa massa) {
        this.id = id;
        this.quantity = quantity;
        this.pizza = pizza;
        this.beguda = beguda;
        this.massa = massa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public Beguda getBeguda() {
        return beguda;
    }


    public Massa getMassa() {
        return massa;
    }

    public void setMassa(Massa massa) {
        this.massa = massa;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", pizza=" + pizza +
                ", beguda=" + beguda +
                ", massa=" + massa +
                '}';
    }
}
