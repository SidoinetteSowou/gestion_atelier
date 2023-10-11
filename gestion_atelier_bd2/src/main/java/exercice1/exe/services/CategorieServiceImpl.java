package exercice1.exe.services;

import java.util.ArrayList;

import exercice1.exe.entities.Categorie;
import exercice1.exe.repositories.ITables;

public class CategorieServiceImpl implements CategorieService {
    // couplage faible
    private ITables<Categorie> categoriesRepository;

    // injection de dependance via le constructeur
    public CategorieServiceImpl(ITables<Categorie> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public int add(Categorie categorie) {
        return categoriesRepository.insert(categorie);
    }

    // injection de dependance via le setter
    public void setcategoriesRepository(ITables<Categorie> categoriesRepository){
        this.categoriesRepository = categoriesRepository;
    }
    @Override
    public ArrayList<Categorie> getAll() {
        return categoriesRepository.findAll();
    }

    @Override
    public int update(Categorie categorie) {
        return categoriesRepository.update(categorie);
    }

    @Override
    public Categorie show(int id) {
        return categoriesRepository.findById(id);
    }

    @Override
    public int remove(int id) {
        // TODO Auto-generated method stub
        return categoriesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
        for (int id=0; id<ids.length; id++){
            if(categoriesRepository.delete(id)==0){
                idsNotDelete[nbre++]=id;
            }
        }
        return idsNotDelete;
    }

    @Override
    public int update(int id, String lib) {
        Categorie cat = categoriesRepository.findById(id);
        cat.setLibelle(lib);
        return categoriesRepository.update(cat);  
    }
    
}
