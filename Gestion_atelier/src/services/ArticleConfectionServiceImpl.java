package services;

import java.util.ArrayList;

import entities.ArticleConfection;
import repositories.List.TableArticleConfections;


public class ArticleConfectionServiceImpl implements ArticleConfectionService{

    //Couplage fort
    private TableArticleConfections articlesRepository=new TableArticleConfections(); 

    @Override
    public int add(ArticleConfection ArticleConfection) {
        return articlesRepository.insert(ArticleConfection);
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        return articlesRepository.findAll();
    }

    @Override
    public int update(ArticleConfection ArticleConfection) {
        return articlesRepository.update(ArticleConfection);
    }

    @Override
    public ArticleConfection show(int id) {
        return articlesRepository.findById(id);
    }

    @Override
    public int remove(int id) {
        return articlesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        int[] idsNotDelete=new int[ids.length];
        int nbre=0;
          for (int id = 0; id < ids.length; id++) {
              if (articlesRepository.delete(id)==0) {
                idsNotDelete[nbre++]=id;

              }
          }
          return idsNotDelete;
    }

    public boolean isUniqueLibelle(String libelle) {
        ArrayList<ArticleConfection> articles = getAll(); 
        for (ArticleConfection article : articles) {
            if (article.getLibelle().equals(libelle)) {
                return false; 
            }
        }
    
        return true; 
    }

    @Override
    public int update(int id, String lib) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
