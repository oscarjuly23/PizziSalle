package model.Decorator;

import model.pizzas.ItemsPizza;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IngExtras extends PizzaDecorator {
    private List<ItemsPizza> items;

    public IngExtras(PizzaD p, List<ItemsPizza> items) {
        super(p);
        this.items = items;
    }

    @Override
    public List<ItemsPizza> getIngredients() {

        return Stream.concat(super.getIngredients().stream(), items.stream()).collect(Collectors.toList());
    }
}
