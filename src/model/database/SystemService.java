package model.database;

import model.User;
import model.database.entity.*;
import model.order.Order;
import model.order.OrderItem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SystemService {

    public static List<pizza> loadPizzas() throws SQLException {
        List<pizza> pizzaList = new ArrayList<>();
        String query = "SELECT * FROM pizza";
        ResultSet resultat = ConnectorDB.getInstance().selectQuery(query);
        try {
            while (resultat.next()) {
                String name = resultat.getString("name");
                int id = resultat.getInt("id_pizza");
                pizzaList.add(new pizza(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizzaList;
    }

    public static List<ingredient> loadIngredients() throws SQLException {
        List<ingredient> ingredientList = new ArrayList<>();
        String query = "SELECT * FROM ingredient";
        ResultSet resultat = ConnectorDB.getInstance().selectQuery(query);
        try {
            while (resultat.next()) {
                String name = resultat.getString("name");
                int id = resultat.getInt("id_ingredient");
                ingredientList.add(new ingredient(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredientList;
    }

    public static List<massa> loadMassas() throws SQLException {
        List<massa> massaList = new ArrayList<>();
        String query = "SELECT * FROM massa";
        ResultSet resultat = ConnectorDB.getInstance().selectQuery(query);
        try {
            while (resultat.next()) {
                String name = resultat.getString("name");
                int id = resultat.getInt("id_massa");
                massaList.add(new massa(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return massaList;
    }

    public static List<drink> loadDrinks() throws SQLException {
        List<drink> drinkList = new ArrayList<>();
        String query = "SELECT * FROM drink";
        ResultSet resultat = ConnectorDB.getInstance().selectQuery(query);
        try {
            while (resultat.next()) {
                String name = resultat.getString("name");
                int id = resultat.getInt("id_drink");
                drinkList.add(new drink(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return drinkList;
    }

    public static List<delegation> loadDelegations() throws SQLException {
        List<delegation> delegationList = new ArrayList<>();
        String query = "SELECT * FROM delegation";
        ResultSet resultat = ConnectorDB.getInstance().selectQuery(query);
        try {
            while (resultat.next()) {
                int id = resultat.getInt("id_delegation");
                String name = resultat.getString("name");
                delegationList.add(new delegation(id, name));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return delegationList;
    }

    public static List<pizzaitem> loadPizzaItems() throws SQLException {
        List<pizzaitem> pizzaitemList = new ArrayList<>();
        String query = "SELECT * FROM pizzaitem;";
        ResultSet resultat = ConnectorDB.getInstance().selectQuery(query);
        try {
            while (resultat.next()) {
                int id = resultat.getInt("id_pizza_item");
                int quantity = resultat.getInt("quantity");
                int id_ingredient = resultat.getInt("id_ingredient");
                int id_pizza = resultat.getInt("id_pizza");
                pizzaitemList.add(new pizzaitem(id, quantity, id_ingredient, id_pizza));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizzaitemList;
    }

    public void insertCostumer(User user)
    {
        String query = "INSERT INTO customer(name, surname1, surname2, phone_number, address, city) VALUES ('" + user.getNom() +"', '"+ user.getCognom1()+"', '"+ user.getCognom2()+"', '"+ user.getTelefon()+"','"+ user.getAdreça()+"', '"+ user.getCity()+"');";
        ConnectorDB.getInstance().insertQuery(query);
        System.out.println(query);
    }

    public static int getIdCustomer(User user) throws SQLException {
        String query = "SELECT id_customer FROM customer WHERE phone_number=" + user.getTelefon() + ";";
        ResultSet resultat = ConnectorDB.getInstance().selectQuery(query);
        int id = 0;
        try {
            while (resultat.next()) {
                id = resultat.getInt("id_customer");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void insertCOrder(Order order)
    {
        String query = "INSERT INTO corder(id_customer, id_delegation) VALUES ('" + order.getUser().getId() +"', '"+ order.getDelegation().getId() +"');";
        ConnectorDB.getInstance().insertQuery(query);
        System.out.println(query);
    }

    public static int getIdOrder(Order order) throws SQLException {
        String query = "SELECT id_order FROM corder WHERE id_customer = '" + order.getUser().getId() + "' AND id_delegation = '"+ order.getDelegation().getId() + "';";
        ResultSet resultat = ConnectorDB.getInstance().selectQuery(query);
        int id = 0;
        try {
            while (resultat.next()) {
                id = resultat.getInt("id_order");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public void insertOrderItem(OrderItem orderItem, Order order)
    {
        String query = "INSERT INTO orderitem(id_pizza, id_massa, id_drink, extra, id_order) VALUES ('" + orderItem.getPizza().getId() +"', '"+ orderItem.getMassa().getId() +"', '"+orderItem.getBeguda().getId() +"', '-' ,  '"+ order.getId() + "');";
        ConnectorDB.getInstance().insertQuery(query);
        System.out.println(query);
    }

    public static int getIdOrderItem(Order order) throws SQLException {
        String query = "SELECT id_order_item FROM orderitem WHERE id_order = '" + order.getId() + "';";
        ResultSet resultat = ConnectorDB.getInstance().selectQuery(query);
        int id = 0;
        try {
            while (resultat.next()) {
                id = resultat.getInt("id_order_item");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
