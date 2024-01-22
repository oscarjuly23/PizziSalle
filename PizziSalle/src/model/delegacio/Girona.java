package model.delegacio;

import model.pizzas.Delegacio;

public class Girona extends Delegacio {
    public Girona(String name, int id) {
        super(name, id);
    }    public String getSpecialPizza() {
        return "Girona";
    }
}