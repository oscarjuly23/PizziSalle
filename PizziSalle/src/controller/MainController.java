package controller;

import model.Decorator.IngExtras;
import model.Decorator.PizzaD;
import model.MainModel;
import model.builder.AllPizzaBuilder;
import model.builder.Builder;
import model.builder.PizzaBuilder;
import model.database.entity.*;
import model.order.Order;
import model.User;
import model.database.SystemService;
import model.order.OrderItem;
import model.pizzas.*;
import view.MainView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainController {
    private Builder builder = new Builder();
    private MainModel mainModel;

    private List<model.database.entity.pizza> pizzaList;
    private List<ingredient> ingredientList;
    private List<model.database.entity.massa> massaList;
    private List<drink> drinkList;
    private List<delegation> delegationList;
    private List<pizzaitem> pizzaitemList;

    private User user;
    private Ingredient ingredient;
    private ItemsPizza itemsPizza;
    private List<ItemsPizza> itemsPizzaList = new ArrayList<>();
    private List<ItemsPizza> extraPizzaList = new ArrayList<>();
    private Beguda beguda;
    private Massa massa;
    private OrderItem orderItem;
    private List<OrderItem> orderItemList = new ArrayList<>();
    private Order order;
    private Delegacio delegacio;

    public MainController(MainView mainView) throws SQLException {
        //Primerament necessitem el SystemService de la BBDD
        SystemService systemService = new SystemService();

        // Primer de tot ens guardem totes les dades de la BBDD
        pizzaList = SystemService.loadPizzas();
        ingredientList = SystemService.loadIngredients();
        massaList = SystemService.loadMassas();
        drinkList = SystemService.loadDrinks();
        delegationList = SystemService.loadDelegations();
        pizzaitemList = SystemService.loadPizzaItems();

        // Construim la mainModel:
        mainModel = new MainModel(orderItemList, ingredientList, massaList, drinkList, delegationList);

        // Generem la delegació aleatoria
        Random r = new Random();
        delegacio = new Delegacio(delegationList.get(r.nextInt(4)).getName(), delegationList.get(r.nextInt(4)).getId());
        //System.out.println(delegacio);

        // Demanem les dades de l'usuari des de la Vista
        mainView.getDadas();
        // Un cop les tenim totes (correctes) creem el nostre objecte user
        user = new User(0, mainView.getNom(), mainView.getCognom1(), mainView.getCognom2(), mainView.getEdat(), mainView.getTelefon(), mainView.getAdreça(), delegacio.getName());

        // Ja podem insertar el nostre usuari a la BBDD
        systemService.insertCostumer(user);

        //Ara necessitem obtenir el ID del Customer que acabem de inserir a la BBDD;
        user.setId(systemService.getIdCustomer(user));
        System.out.println(user);

        // Quan ja tenim l'usuari inserit passarem a llegir la comanda des de la Vista.
        mainView.getComanda(delegacio.getName());

        int pizzaId = 0;
        // Depenent la pizza que esculleixi agafem els seus ingredients i els guardem en un objecte
        for (model.database.entity.pizza value : pizzaList) {
            if (value.getName().equals(mainView.getPizza())) {
                pizzaId = value.getId();
                for (model.database.entity.pizzaitem pizzaitem : pizzaitemList) {
                    if (value.getId() == pizzaitem.getId_pizza()) {
                        for (model.database.entity.ingredient item : ingredientList) {
                            if (pizzaitem.getId_ingredient() == item.getId()) {
                                ingredient = new Ingredient(item.getId(), item.getName());
                                itemsPizza = new ItemsPizza(ingredient, pizzaitem.getQuantity());
                                itemsPizzaList.add(itemsPizza);
                                //System.out.println(itemsPizza.getIngredient().getNom());
                            }
                        }
                    }
                }
            }
        }

        //Ens guardem la massa
        for (int i = 0; i < massaList.size(); i++) {
            if (massaList.get(i).getName().equals(mainView.getMassa()))
            {
                massa = new Massa(massaList.get(i).getId(),mainView.getMassa());
            }

        }
        //System.out.println(massa);

        //Ens guardem la beguda
        for (int i = 0; i < drinkList.size(); i++) {
            if (drinkList.get(i).getName().equals(mainView.getBeguda()))
            {
                beguda = new Beguda(drinkList.get(i).getId(), mainView.getBeguda());
            }

        }
        //System.out.println(beguda);

        // Un cop arribat aquest punt ja podem construir la nostre pizza amb el Builder:
        PizzaBuilder pizzaBuilder = new AllPizzaBuilder();
        builder.setPizzaBuilder(pizzaBuilder);
        //builder.buildPizza(mainView.getPizza(), itemsPizzaList, extraPizzaList, massa);
        builder.buildPizza(mainView.getPizza(), itemsPizzaList, massa);
        Pizza pizza = builder.getPizza();
        PizzaD pizza1 = builder.getPizza();

        // Ara ja tenim la pizza contruida, només ens falta decorar-la amb els extras que demana l'usuari.
        for (int i = 0; i < mainView.getExtras().size(); i++) {
            for (int j = 0; j < ingredientList.size(); j++) {
                if (ingredientList.get(j).getName().equals(mainView.getExtras().get(i))){
                    ingredient = new Ingredient(ingredientList.get(j).getId(), mainView.getExtras().get(i));
                    itemsPizza = new ItemsPizza(ingredient, 1);
                    extraPizzaList.add(itemsPizza);
                }
            }
        }
        pizza1 = new IngExtras(pizza1, extraPizzaList);
        //System.out.println(pizza1.getIngredients());

        //Després de decorar-la ens guardem aquets extres en el objecte inicial.
        pizza.setIngredientsPizzaList(pizza1.getIngredients());
        pizza.setId(pizzaId);
        //System.out.println(pizza);

        // Arribat aquest punt ja ho tenim tot llest per crear els objectes que ens queden per a preparar els inserts a la BBDD.
        orderItem = new OrderItem(0, 1, pizza, beguda, massa);
        orderItemList.add(orderItem);
        order = new Order(0, user, delegacio, orderItemList);

        // Un cop tenim tots els objectes fem els inserts a la BBDD:
        //Primer omplim la taula 'corder':
        systemService.insertCOrder(order);

        //Necessitem obtenir el id_order que acabem de generar
        order.setId(systemService.getIdOrder(order));
        //System.out.println(order);

        //Un cop optingut podem fer per últim el insert del orderitem i ja tenim la comanda feta!
        systemService.insertOrderItem(orderItem, order);

        //Agafem el ID del orderitem per a setejarlo al nostre objecte.
        orderItem.setId(systemService.getIdOrderItem(order));
        //System.out.println(orderItem);
    }
}
