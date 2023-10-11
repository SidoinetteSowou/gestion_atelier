package exercice1.exe;

import java.util.Scanner;

import exercice1.exe.entities.ArticleConfection;
import exercice1.exe.entities.Categorie;
import exercice1.exe.repositories.ITables;
import exercice1.exe.repositories.BD.CategorieRepository;
import exercice1.exe.repositories.BD.ArticleConfectionRepository;
import exercice1.exe.services.ArticleConfectionService;
import exercice1.exe.services.ArticleConfectionServiceImpl;
import exercice1.exe.services.CategorieService;
import exercice1.exe.services.CategorieServiceImpl;

public class Main {
    private static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) {
        ITables <Categorie> repository =new CategorieRepository();
        CategorieService categorieServiceImpl = new CategorieServiceImpl(repository);

        ITables <ArticleConfection> artRepository =new ArticleConfectionRepository();
        ArticleConfectionService ArticleServiceImpl = new ArticleConfectionServiceImpl(artRepository);
        int choix;
        do {
            vide();
            System.out.println("=======================================");
            System.out.println("               ENTETE");
            System.out.println("=======================================");
            System.out.println("1-Categorie");
            System.out.println("2-Article de confection");
            System.out.println("3-Unités");
            System.out.println("4-Quitter");
            choix=scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    int choixMenu;
                    do{
                        vide();
                        System.out.println("=======================================");
                        System.out.println("               CATEGORIE");
                        System.out.println("=======================================");
                        System.out.println("1-AJOUTER");
                        System.out.println("2-LISTER");
                        System.out.println("3-SUPPRIMER");
                        System.out.println("4-SUPRESSION MULTIPLE");
                        System.out.println("5-MODIFIER");
                        System.out.println("6-QUITTER");
                        choixMenu=scanner.nextInt();
                        scanner.nextLine();
                        switch (choixMenu) {
                            case 1:
                                // boolean libUnique;
                                System.out.println("Libelle");
                                Categorie categorie=new Categorie(scanner.nextLine());
                                // System.out.println(categorieServiceImpl);
                                int t=categorieServiceImpl.add(categorie);
                                System.out.println(t);
                                pause();
                                break;
                            case 2:
                                vide();
                                System.out.println("=======================================");
                                System.out.println("           LISTE CATEGORIE");
                                System.out.println("=======================================");
                                // programation fonctionnel
                                categorieServiceImpl.getAll().forEach(System.out::println);
                                pause();
                                break;
                            default:
                                break;
                        }
                    }while(choixMenu!=6);
                case 2:
                    break;
                case 3:
                    System.out.println("id");
                    int id=scanner.nextInt();
                    System.out.println(categorieServiceImpl.show(id));
                    break;
                default:
                    break;
            }
        } while (choix!=4);
    }

    public static void vide(){
        System.out.print("Everything on the console will cleared");
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause(){
		System.out.println("Appuyer sur une touche pour continuer...");
		scanner.nextLine();
	}
}