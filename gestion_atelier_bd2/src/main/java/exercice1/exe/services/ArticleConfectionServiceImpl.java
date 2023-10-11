package exercice1.exe.services;
import java.util.ArrayList;
import exercice1.exe.entities.ArticleConfection;
import exercice1.exe.repositories.ITables;

public class ArticleConfectionServiceImpl implements ArticleConfectionService{

    // couplage faible
    private ITables<ArticleConfection> articlesRepository;

    // injection de dependance via le constructeur
    public ArticleConfectionServiceImpl(ITables<ArticleConfection> articlesRepository) {
        this.articlesRepository = articlesRepository;
    }


    @Override
    public int add(ArticleConfection data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public ArrayList<ArticleConfection> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public int update(ArticleConfection data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public ArticleConfection show(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    public int remove(int id) {
        return articlesRepository.delete(id);
    }

    @Override
    public int[] remove(int[] ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }


    @Override
    public int update(int id, String lib) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    
    
}
