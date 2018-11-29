package org.academiadecodigo.variachis.persistence.dao;

import java.util.List;

public interface Dao<T>{


    List<T> findAll();

    T findById(Integer id);


    T saveOrUpdate(T modelobject);


    void delete(Integer id);
}
