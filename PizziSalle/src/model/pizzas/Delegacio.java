package model.pizzas;

public class Delegacio {
    private String name;
    private int id;

    public Delegacio(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Delegacio{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
