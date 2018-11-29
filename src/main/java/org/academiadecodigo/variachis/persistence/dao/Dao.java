package org.academiadecodigo.variachis.persistence.dao;

public interface Dao<T>{


    T findAll();

    T findById(Integer id);


    T saveOrUpdate(T modelobject);


    void delete(Integer id);
}
