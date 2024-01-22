package model.pizzas;

public class ItemsPizza {
    private Ingredient ingredient;
    private int qIngredient;

    public ItemsPizza(Ingredient ingredient, int qIngredient) {
        this.ingredient = ingredient;
        this.qIngredient = qIngredient;
    }

    @Override
    public String toString() {
        return "ItemsPizza{" +
                "ingredient=" + ingredient +
                ", qIngredient=" + qIngredient +
                '}';
    }
}