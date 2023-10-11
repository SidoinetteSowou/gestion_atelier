package exercice1.exe.repositories.BD;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exercice1.exe.entities.Categorie;
import exercice1.exe.repositories.ITables;

public class CategorieRepository extends Mysql implements ITables<Categorie>{
    @Override
    public int delete(int id) {
        return 0;
        
    }

    @Override
    public ArrayList<Categorie> findAll() {
        ArrayList<Categorie> categories = new ArrayList<>();
        try {
            connexion();
            Statement statement=con.createStatement();
            ResultSet rs= statement.executeQuery("SELECT id,libelle FROM categorie");
            while(rs.next()){
                Categorie categorie=new Categorie(rs.getInt("id"),rs.getString("libelle"));
                categories.add(categorie);

            }
            con.close();
            statement.close();
            rs.close();
        } catch (Exception e) {
            System.out.println("Erreur !!!!!!");
        }
        
        return categories;
    }

    @Override
    public Categorie findById(int id) {
        Categorie categorie=null;
          try {
            // 1ere etape:chargement du Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2e etape:creer l'objet de connection
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_coutute","root", "");
            // Classe PreparedStatement=executer les requetes preparés
            String sql="SELECT id,libelle FROM categorie where id=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs=statement.executeQuery();
            if(rs.next()){
                categorie=new Categorie(rs.getInt("id"),rs.getString("libelle"));

            }
            conn.close();
            statement.close();
            rs.close();
           
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de Chargement du Driver");
        }
        catch (SQLException e) {
            System.out.println("Echec de la connection");
        }
        return categorie;
    }

    @Override
    public int indexOf(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int insert(Categorie data) {
        int nbrLigne=0;
        try {    
            connexion();
            // NE MARCHE PAS
            System.out.println(data.toString());
            
            pause();
            String sql="INSERT INTO `categorie` (`libelle`) VALUES (?)";
            PreparedStatement statement=con.prepareStatement(sql);
            statement.setString(2, data.getLibelle());
            nbrLigne=statement.executeUpdate();
            con.close();
            statement.close();
        }
        catch (Exception e) {
            System.out.println("Echec de la connection");
        }
        return nbrLigne;
    }

    @Override
    public int update(Categorie data) {
        int nbrLigne=0;
        try {
            // 1ere etape:chargement du Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2e etape:creer l'objet de connection
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_coutute","root", "");
            String sql="UPDATE `categorie` SET `libelle`=? WHERE `id`=?";
            PreparedStatement statement=conn.prepareStatement(sql);
            statement.setString(1, data.getLibelle());
            statement.setInt(2, data.getId());
            nbrLigne=statement.executeUpdate();
            conn.close();
            statement.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Erreur de Chargement du Driver");
        }
        catch (SQLException e) {
            System.out.println("Echec de la connection");
        }
        return nbrLigne;
    }
    
}
