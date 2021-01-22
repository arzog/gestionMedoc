package iram.student.patterns.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnexion {
    private volatile static DBConnexion single;
    private static Connection conn;

    private DBConnexion() {
        String url = "jdbc:mysql://localhost:3306/gestionmedoc?autoReconnect=true&useSSL=false";
        String user = "phpMyAdmin";
        String pswd = "phpMyAdmin";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pswd);
            System.out.println("connection OK");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Erreur lors de l'initialisation de la connexion");
            System.out.println(e);
        }
    }

    public static Connection getInstance(){
        if(single==null){
            synchronized (Connection.class){
                if(single==null){
                    single = new DBConnexion();
                }
            }
        }
        return conn;
    }
}
