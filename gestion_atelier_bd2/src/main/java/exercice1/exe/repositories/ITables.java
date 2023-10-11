package exercice1.exe.repositories;

import java.util.ArrayList;

import exercice1.exe.entities.AbstractEntitie;

// interface generique
public interface ITables <T extends AbstractEntitie>{
    int insert (T data);
    int update (T data);
    ArrayList<T> findAll();
    T findById(int id);
    int delete(int id);
    int indexOf(int id);
}
