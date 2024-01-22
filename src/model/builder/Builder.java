package model.builder;

import model.pizzas.ItemsPizza;
import model.pizzas.Massa;
import model.pizzas.Pizza;

import java.util.List;

public class Builder {
    private PizzaBuilder pizzaBuilder;
    public void setPizzaBuilder(PizzaBuilder pb) { pizzaBuilder = pb; }
    public Pizza getPizza() { return pizzaBuilder.getPizza(); }

    //public void buildPizza(String name, List<ItemsPizza> ingredients, List<ItemsPizza> extras, Massa massa) {
    public void buildPizza(String name, List<ItemsPizza> ingredients, Massa massa) {
        pizzaBuilder.newPizza();
        pizzaBuilder.buildName(name);
        pizzaBuilder.buildIngredients(ingredients);
        //pizzaBuilder.buildExtras(extras);
        pizzaBuilder.buildMassa(massa);
    }
}