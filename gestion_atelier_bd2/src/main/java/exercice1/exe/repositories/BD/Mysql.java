package exercice1.exe.repositories.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;



public class Mysql {
    protected Connection con ;
    private static Scanner scanner =new Scanner(System.in);
    
    public void connexion(){
        try {
            // 1ere etape:chargement du Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2e etape:creer l'objet de connection
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_coutute","root", "");
        } 
        catch (ClassNotFoundException e) {
            System.out.println("Erreur de Chargement du Driver");
        }
        catch (SQLException e) {
            System.out.println("Echec de la connexion");
        }
    }

    public void executeSelect(String rq){

    }

    public void executeUpdate(){

    }

    public static void pause(){
		System.out.println("Appuyer sur une touche pour continuer...");
		scanner.nextLine();
	}
    
}
