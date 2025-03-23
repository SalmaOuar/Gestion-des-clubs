/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexion;
import java.sql.Connection;
/**
 *
 * @author Yoga
 */
public class Main {
    public static void main(String[] args) {
        Connection conn = Connexion.getInstance().getCn();
        if (conn != null) {
            System.out.println("Connexion établie avec succès !");
        } else {
            System.out.println("Échec de la connexion !");
        }
    }
}
