package org.academiadecodigo.variachis.controller;

import org.academiadecodigo.variachis.persistence.dao.jpa.ClientDao;
import org.academiadecodigo.variachis.persistence.dao.jpa.HabitDao;
import org.academiadecodigo.variachis.persistence.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTest {

    private ClientDao clientDao;
    private HabitDao habitDao;

    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Autowired
    public void setHabitDao(HabitDao habitDao) {
        this.habitDao = habitDao;
    }

    public Client show(Integer id) {
        return clientDao.findById(id);

    }
}
