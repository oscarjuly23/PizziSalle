package model.builder;

import model.pizzas.ItemsPizza;
import model.pizzas.Massa;
import model.pizzas.Pizza;

import java.util.List;

public abstract class PizzaBuilder {
    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void newPizza() {
        pizza = new Pizza();
    }
    public abstract void buildName(String name);
    public abstract void buildIngredients(List<ItemsPizza> ingredients);
    //public abstract void buildExtras(List<ItemsPizza> extras);
    public abstract void buildMassa(Massa massa);

}

