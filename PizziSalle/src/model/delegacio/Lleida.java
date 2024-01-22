package model.delegacio;

import model.pizzas.Delegacio;

public class Lleida extends Delegacio {
    public Lleida(String name, int id) {
        super(name, id);
    }    public String getSpecialPizza() {
        return "Lleida";
    }
}
