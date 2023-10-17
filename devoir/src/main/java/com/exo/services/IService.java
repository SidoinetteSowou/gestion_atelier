package com.exo.services;

import java.util.ArrayList;

public interface IService <T>{
    int add(T data);
    ArrayList<T> getAll();
    int update(T data);
    T show(int id);
    int remove(int id);
    int[] remove(int[] ids);
}
