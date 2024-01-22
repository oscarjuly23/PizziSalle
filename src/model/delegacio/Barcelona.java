package model.delegacio;

import model.pizzas.Delegacio;

public class Barcelona extends Delegacio {
    public Barcelona(String name, int id) {
        super(name, id);
    }
    public String getSpecialPizza() {
        return "Barcelona";
    }
}
