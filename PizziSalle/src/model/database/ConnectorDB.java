package model.database;

import java.sql.*;

public class ConnectorDB {
    private static String dbIp;
    private static int port;
    private static String dbName;
    private static String dbUser;
    private static String dbPass;
    private static String url;
    private static Connection conn;
    private static Statement s;
    private static ConnectorDB instance;

    public ConnectorDB(String usr, String pass, String db, String ip, int port) {
        this.dbUser = usr;
        this.dbPass = pass;
        this.dbName = db;
        this.dbIp = ip;
        this.port = port;
        this.url = "jdbc:mysql://" + ip + ":" + port + "/" + dbName;
        this.instance = null;
    }

    public static ConnectorDB getInstance() {
        if (instance == null) {
            instance = new ConnectorDB(dbUser,dbPass,dbName,dbIp,port);
            instance.connect();
        }
        return instance;
    }

    public void connect() {
        try {
            Class.forName("com.mysql.jdbc.Connection");
            conn = DriverManager.getConnection(url, dbUser, dbPass);
            if (conn != null) {
                //System.out.println("Connexió a base de dades " + url + " ... Ok");
            }
        }
        catch(SQLException ex) {
            System.out.println("Problema al connecta-nos a la BBDD --> "+ url);
        }
        catch(ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }

    public void insertQuery(String query){
        try {
            s = conn.createStatement();
            s.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println("Problema al Inserir --> " + ex.getSQLState());
        }
    }

    public ResultSet selectQuery(String query){
        ResultSet rs = null;
        try {
            s = conn.createStatement();
            rs = s.executeQuery (query);

        } catch (SQLException ex) {
            System.out.println("Problema al Recuperar les dades --> " + ex.getSQLState());
        }
        return rs;
    }
}