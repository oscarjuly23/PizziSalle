import controller.MainController;
import model.MainModel;
import model.database.ConnectorDB;
import model.database.SystemService;
import view.MainView;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Main
{
    public static void main(String[] args) throws SQLException {
        // Primerament la connexió a la BBDD
        ConnectorDB connectorDB = new ConnectorDB("root", "", "pizzisalle", "localhost", 3306);

        //La Model
        MainModel mainModel = new MainModel();

        //La vista
        MainView mainView = new MainView();

        //El controlador amb la conexió amb la vista
        MainController mainController = new MainController(mainView);
    }
}
