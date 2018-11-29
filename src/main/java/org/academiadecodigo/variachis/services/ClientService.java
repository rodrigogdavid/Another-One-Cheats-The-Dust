package org.academiadecodigo.variachis.services;


import org.academiadecodigo.variachis.persistence.dao.jpa.ClientDao;
import org.academiadecodigo.variachis.persistence.model.Client;
import org.academiadecodigo.variachis.persistence.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private ClientDao clientDao;


    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public Client get(Integer id){
        return clientDao.findById(id);
    }

    public Habit getHabit(Integer id){
        Client client = clientDao.findById(id);

        return client.getHabit();
    }

    @Transactional
    public Client save (Client client){

        return clientDao.saveOrUpdate(client);
    }

    @Transactional
    public void delete(Integer id){

        //Client client = clientDao.findById(id);

        clientDao.delete(id);
    }




}
