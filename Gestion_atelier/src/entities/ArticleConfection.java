package entities;
import java.util.ArrayList;

public class ArticleConfection extends AbstractEntities{
    
    
    private double prix;
    private double qte;
    private static int nbre;

    public ArticleConfection(){
        super();
    }

    public ArticleConfection(String lib,double prix,double qte){
        super(++nbre,lib);
        this.prix=prix;
        this.qte=qte;
    }

    
    
    // Attributs navigationnels 
    // ManyToOne
    private Categorie categorie;
    // ManyToMany
        // Couplage Fort
    ArrayList <Unite> unites =new ArrayList<>();

    
   

    @Override
    public String toString() {
        return "ArticleConfection [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", qte=" + qte + "categorie= "+categorie+"]";
    }




    public double getPrix() {
        return prix;
    }




    public void setPrix(double prix) {
        this.prix = prix;
    }




    public double getQte() {
        return qte;
    }




    public void setQte(double qte) {
        this.qte = qte;
    }




    public Categorie getCategorie() {
        return categorie;
    }




    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }




    public ArrayList<Unite> getUnites() {
        return unites;
    }




    public void setUnites(ArrayList<Unite> unites) {
        this.unites = unites;
    }

    
}


    

