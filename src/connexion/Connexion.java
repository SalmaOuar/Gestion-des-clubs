/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
/**
 *
 * @author Yoga
 */
public class Connexion {
    private static Connexion instance = null;
    private Connection cn = null;
    
    private final String url = "jdbc:mysql://localhost:3306/gestion_clubs";
    private final String login = "root";
    private final String password = "";

    // Constructeur privé pour empêcher l'instanciation directe
    public Connexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            cn = DriverManager.getConnection(url, login, password);
            System.out.println("Connexion réussie à la base de données !");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver introuvable");
        } catch (SQLException ex) {
            System.out.println("Erreur de connexion : " + ex.getMessage());
        }
    }

    // Méthode d'accès à l'instance unique (avec synchronisation pour éviter les problèmes de concurrence)
    public static synchronized Connexion getInstance() {
        if (instance == null) {
            instance = new Connexion();
        }
        return instance;
    }

    // Méthode pour obtenir la connexion
    public Connection getCn() {
        return cn;
    }
}
