package model.database.entity;

public class delegation {
    int id;
    String name;

    public delegation(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "delegation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
