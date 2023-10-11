package exercice1.exe.entities;

public class Categorie extends AbstractEntitie{
    private static int nbre;

    public Categorie(String libelle){
        super(++nbre,libelle);
    }

    public Categorie(int id, String libelle) {
        super(id, libelle);
    }

    // public Categorie(String libelle) {
    //     super(libelle);
    // }

    // const defaut
    public Categorie() {
        super();
    }


    @Override
    public String toString() {
        return "Categorie"+super.toString();
    }

    
    
    
}
