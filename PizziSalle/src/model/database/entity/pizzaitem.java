package model.database.entity;

public class pizzaitem {
    int id;
    int quantity;
    int id_ingredient;
    int id_pizza;

    public pizzaitem(int id, int quantity, int id_ingredient, int id_pizza) {
        this.id = id;
        this.quantity = quantity;
        this.id_ingredient = id_ingredient;
        this.id_pizza = id_pizza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getId_ingredient() {
        return id_ingredient;
    }

    public void setId_ingredient(int id_ingredient) {
        this.id_ingredient = id_ingredient;
    }

    public int getId_pizza() {
        return id_pizza;
    }

    public void setId_pizza(int id_pizza) {
        this.id_pizza = id_pizza;
    }

    @Override
    public String toString() {
        return "pizzaitem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", id_ingredient=" + id_ingredient +
                ", id_pizza=" + id_pizza +
                '}';
    }
}
