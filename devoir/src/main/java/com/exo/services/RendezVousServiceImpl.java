package com.exo.services;

import java.util.ArrayList;


import com.exo.entities.RendezVous;
import com.exo.repositories.core.Repository;

public class RendezVousServiceImpl implements RendezVousService{
    protected Repository<RendezVous> rdvRepository;

    public RendezVousServiceImpl(Repository<RendezVous> rdvRepository) {
        this.rdvRepository = rdvRepository;
       
    }

    @Override
    public int add(RendezVous data) {
        return rdvRepository.insert(data);
    }

    @Override
    public ArrayList<RendezVous> getAll() {
       return rdvRepository.findAll();
    }

    @Override
    public int update(RendezVous data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public RendezVous show(int id) {
        return rdvRepository.findById(id);
    }

    @Override
    public int remove(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public int[] remove(int[] ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public ArrayList<RendezVous> show(String d,String h,int id) {
        return rdvRepository.findAll(d,h,id);
    }
    
}
