import java.util.ArrayList;
import java.util.Scanner;

import entities.ArticleConfection;
import entities.Categorie;
import services.ArticleConfectionServiceImpl;
import services.CategorieServiceImpl;


public class App {
    private static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        CategorieServiceImpl categorieServiceImpl =new CategorieServiceImpl();
        ArticleConfectionServiceImpl articleConfectionServiceImpl =new ArticleConfectionServiceImpl();
        int choix;
        
        do {
            vide();
            System.out.println("=======================================");
            System.out.println("ENTETE");
            System.out.println("=======================================");
            System.out.println("1- Faire un ajout");
            System.out.println("2- Lister");
            System.out.println("3- Faire une Modification");
            System.out.println("4- Faire une Supprission");
            System.out.println("5- Faire une Supprission Multiple");
            System.out.println("6- Faire une Edition");
            System.out.println("7- Quitter ");
            choix=scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    int choix1;
                    do {
                        vide();
                        System.out.println("=======================================");
                        System.out.println("AJOUT");
                        System.out.println("=======================================");
                        System.out.println("1- Catégorie");
                        System.out.println("2- Article");
                        System.out.println("3- Quitter ");
                        choix1=scanner.nextInt();
                        scanner.nextLine();

                        switch (choix1) {
                            case 1:
                                boolean libUnique;
                                do{
                                    System.out.println("Veuillez entrez le libelle");
                                    String lib = scanner.nextLine();
                                    libUnique = categorieServiceImpl.isUniqueLibelle(lib);
                                    if (categorieServiceImpl.isUniqueLibelle(lib)) {
                                        Categorie categorie =new Categorie(lib);
                                        categorieServiceImpl.add(categorie);
                                        System.out.println("Catégorie ajoutée ");
                                    } else {
                                        System.out.println("'" + lib + "' existe déjà. Entrez encore.");
                                    } 
                                }while(!libUnique) ; 
                                break;
                            case 2:
                                do{
                                    categorieServiceImpl.getAll().forEach(System.out::println);
                                    System.out.println("Veuillez entrez un id");
                                    int idCat=scanner.nextInt();
                                    scanner.nextLine();
                                    Categorie cat=categorieServiceImpl.show(idCat);
                                    // 
                                    System.out.println("Veuillez entrez le libelle");
                                    String lib = scanner.nextLine();
                                    libUnique = articleConfectionServiceImpl.isUniqueLibelle(lib);
                                    if (articleConfectionServiceImpl.isUniqueLibelle(lib)) {
                                        System.out.println("Veuillez entrez le prix");
                                        double prix = scanner.nextDouble();
                                        System.out.println("Veuillez entrez la quantité");
                                        double qte = scanner.nextDouble();
                                        ArticleConfection article =new ArticleConfection(lib,prix,qte);
                                        article.setCategorie(cat);
                                        articleConfectionServiceImpl.add(article);

                                        System.out.println("Article ajoutée ");
                                    } else {
                                        System.out.println("'" + lib + "' existe déjà. Entrez encore.");
                                    } 
                                }while(!libUnique) ; 
                                break;
                        
                        }
                    } while (choix1!=3);    
                    break;

                case 2:
                    vide();
                    do {
                        System.out.println("=======================================");
                        System.out.println("LISTE");
                        System.out.println("=======================================");
                        System.out.println("1- Catégorie");
                        System.out.println("2- Article");
                        System.out.println("3- Quitter ");
                        choix1=scanner.nextInt();
                        scanner.nextLine();
                        switch (choix1) {
                            case 1:
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                break;
                            case 2:
                                articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                break;
                        }
                        
                    } while (choix1!=3);
                    break;
                case 3:
                    do {
                        vide();
                        System.out.println("=======================================");
                        System.out.println("             MODIFICATION");
                        System.out.println("=======================================");
                        System.out.println("1- Catégorie");
                        System.out.println("2- Article");
                        System.out.println("3- Quitter ");
                        choix1=scanner.nextInt();
                        
                        switch (choix1) {
                            case 1:
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("entrer un id");
                                int id=scanner.nextInt();
                                scanner.nextLine();
                                // 
                                System.out.println("entrer la modification");
                                String lib=scanner.nextLine();
                                categorieServiceImpl.update(id,lib);

                                break;
                            case 2:
                                int choixMod;
                                articleConfectionServiceImpl.getAll().forEach(System.out::println);
                                System.out.println("entrer un id");
                                id=scanner.nextInt();
                                scanner.nextLine();
                                // 
                                ArticleConfection art = articleConfectionServiceImpl.show(id);
                                do {
                                    vide();
                                    System.out.println("=======================================");
                                    System.out.println("             MODIFICATION");
                                    System.out.println("=======================================");
                                    System.out.println("1-Modifier le libelle");
                                    System.out.println("2-Modifier le prix");
                                    System.out.println("3-Modifier la quantité");
                                    System.out.println("4-Quitter");
                                    choixMod=scanner.nextInt();
                                    scanner.nextLine();
                                    switch (choixMod) {
                                        case 1:
                                            System.out.println(" entrer le libelle");
                                            lib=scanner.nextLine();
                                            art.setLibelle(lib);
                                            break;
                                        case 2:
                                            System.out.println(" entrer le libelle");
                                            double prix=scanner.nextDouble();
                                            art.setPrix(prix);
                                            break;
                                        case 3:
                                            System.out.println(" entrer le libelle");
                                            double qte=scanner.nextDouble();
                                            art.setQte(qte);;
                                            break;
                                    }
                                    articleConfectionServiceImpl.update(art);
                                 
                                } while (choixMod!=4);
                                break;
                        }
                        
                    } while (choix1!=3);
                    break;
                case 4:
                    do {
                        vide();
                        System.out.println("=======================================");
                        System.out.println("             SUPPRESSION");
                        System.out.println("=======================================");
                        System.out.println("1- Catégorie");
                        System.out.println("2- Article");
                        System.out.println("3- Quitter ");
                        choix1=scanner.nextInt();
                        scanner.nextLine();
                        switch (choix1) {
                            case 1:
                                System.out.println("choisir un id");
                                categorieServiceImpl.remove(scanner.nextInt());
                                break;
                            case 2:
                                 System.out.println("choisir un id");
                                articleConfectionServiceImpl.remove(scanner.nextInt());
                                break;
                        }
                        
                    } while (choix1!=3);
                    break;

                case 5:
                    do {
                        vide();
                        vide();
                        System.out.println("=======================================");
                        System.out.println("  SUPPRESSION MULTIPLE");
                        System.out.println("=======================================");
                        System.out.println("1- Catégorie");
                        System.out.println("2- Article");
                        System.out.println("3- Quitter ");
                        choix1=scanner.nextInt();
            
                        switch (choix1) {
                            case 1:
                                System.out.println("nombre de catégorie à SUPPRIMER");
                                int N=scanner.nextInt();
                                int[] ids=new int[N];
                                for (int index = 0; index <N; index++) {
                                    System.out.println("choisir un id");
                                    ids[index] = scanner.nextInt();
                                }
                                categorieServiceImpl.remove(ids);
                                break;
                            case 2:
                                 System.out.println("choisir un id");
                                articleConfectionServiceImpl.remove(scanner.nextInt());
                                break;
                        }
                        
                    } while (choix1!=3);
                    break;
                case 6:
                    do {
                        vide();
                        vide();
                        System.out.println("=======================================");
                        System.out.println("  EDITER");
                        System.out.println("=======================================");
                        System.out.println("1- Catégorie");
                        System.out.println("2- Article");
                        System.out.println("3- Quitter ");
                        choix1=scanner.nextInt();
            
                        switch (choix1) {
                            case 1:
                                System.out.println("choisir un id");
                                Categorie cat=categorieServiceImpl.show(scanner.nextInt()) ;
                               cat.toString();
                                break;
                            case 2:
                                System.out.println("choisir un id");
                                ArticleConfection art = articleConfectionServiceImpl.show(scanner.nextInt());
                                art.toString();
                                break;
                        }
                        
                    } while (choix1!=3);
                    
                    break;
            
                default:
                    break;
            }
    
        } while (choix!=7);
    }
    
   
    public static void vide(){
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
}
