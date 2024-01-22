package model;

import model.database.entity.delegation;
import model.database.entity.drink;
import model.database.entity.ingredient;
import model.database.entity.massa;
import model.order.OrderItem;

import java.util.List;

public class MainModel
{
    private List<OrderItem> pizzaCommandList;
    private List<ingredient> ingredientList;
    private List<massa> massaList;
    private List<drink> begudaList;
    private List<delegation> delegacioList;

    public MainModel(List<OrderItem> pizzaCommandList, List<ingredient> ingredientList, List<massa> massaList, List<drink> begudaList, List<delegation> delegacioList) {
        this.pizzaCommandList = pizzaCommandList;
        this.ingredientList = ingredientList;
        this.massaList = massaList;
        this.begudaList = begudaList;
        this.delegacioList = delegacioList;
    }

    public MainModel() {
    }
}
