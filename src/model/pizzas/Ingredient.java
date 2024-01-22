package model.pizzas;

public class Ingredient {
    private int id;
    private String nom;

    public Ingredient(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
