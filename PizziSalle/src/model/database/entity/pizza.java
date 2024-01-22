package model.database.entity;

public class pizza {
    int id;
    String name;

    public pizza(int id, String name) {
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
        return "pizza{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
