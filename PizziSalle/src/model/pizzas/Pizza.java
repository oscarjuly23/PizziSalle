package model.pizzas;

import model.Decorator.PizzaD;

import java.util.List;

public class Pizza implements PizzaD {
    private int id;
    private String name;
    private List<ItemsPizza> ingredientsPizzaList;
    private Massa massa;

    public Pizza() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredientsPizzaList(List<ItemsPizza> ingredientsPizzaList) {
        this.ingredientsPizzaList = ingredientsPizzaList;
    }

    public Massa getMassa() {
        return massa;
    }

    public void setMassa(Massa massa) {
        this.massa = massa;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ingredientsPizzaList=" + ingredientsPizzaList +
                ", massa=" + massa +
                '}';
    }

    @Override
    public List<ItemsPizza> getIngredients() {
        return ingredientsPizzaList;
    }
}
