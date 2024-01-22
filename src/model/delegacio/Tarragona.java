package model.delegacio;

import model.pizzas.Delegacio;

public class Tarragona extends Delegacio {
    public Tarragona(String name, int id) {
        super(name, id);
    }    public String getSpecialPizza() {
        return "Tarragona";
    }
}
