package model.Decorator;


import model.pizzas.ItemsPizza;

import java.util.List;

public abstract class PizzaDecorator implements PizzaD {
    private final PizzaD decoratedPizza;

    public PizzaDecorator(PizzaD p) {
        this.decoratedPizza = p;
    }

    @Override
    public List<ItemsPizza> getIngredients() {
        return decoratedPizza.getIngredients();
    }
}
