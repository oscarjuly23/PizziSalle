package model.builder;

import model.pizzas.ItemsPizza;
import model.pizzas.Massa;

import java.util.List;

public class AllPizzaBuilder extends PizzaBuilder {

    @Override
    public void buildName(String name) {
        pizza.setName(name);
    }

    @Override
    public void buildIngredients(List<ItemsPizza> ingredients) {
        pizza.setIngredientsPizzaList(ingredients);
    }

//    @Override
//    public void buildExtras(List<ItemsPizza> extras) {
//        pizza.setExtrasPizzaList(extras);
//    }

    @Override
    public void buildMassa(Massa massa) {
        pizza.setMassa(massa);
    }
}
