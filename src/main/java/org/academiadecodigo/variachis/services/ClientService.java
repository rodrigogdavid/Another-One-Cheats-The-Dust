package org.academiadecodigo.variachis.services;


import org.academiadecodigo.variachis.persistence.dao.jpa.ClientDao;
import org.academiadecodigo.variachis.persistence.model.Client;
import org.academiadecodigo.variachis.persistence.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    private ClientDao clientDao;


    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public Client get(Integer id) {
        return clientDao.findById(id);
    }

    public Habit getHabit(Integer id) {
        Client client = clientDao.findById(id);

        return client.getHabit();
    }

    @Transactional
    public Client save(Client client) {

        return clientDao.saveOrUpdate(client);
    }

    @Transactional
    public void delete(Integer id) {

        //Client client = clientDao.findById(id);

        clientDao.delete(id);
    }

    @Transactional
    public Integer clientScore(Integer id) {
        Integer score = 0;

        Client client = clientDao.findById(id);

        System.out.println("\n\n\n" + client + "\n\n\n");


        int imc = Math.round(client.getWeight() / (client.getHeight() * client.getHeight()));

        if (imc > 30) {
            score += 7;
        }

        if (imc < 10) {
            score += 7;
        }

        if (client.getAge() > 65) {
            score += 15;
        }

        if (client.getAge() > 50 && client.getAge() <= 65) {
            score += 8;
        }

        if (client.getHeartBeats() > 100 && client.getHeartBeats() <= 120) {
            score += 5;
        }

        if (client.getHeartBeats() > 120) {
            score += 8;
        }

        return score;


    }

    public Client findByName(String firstName, String lastName) {

        List<Client> clients = clientDao.findAll();

        Client clientLogin = null;

        for (Client client : clients) {
            if (client.getFirstName().equals(firstName) && client.getLastName().equals(lastName)) {

                clientLogin = client;
            }
        }
        return clientLogin;
    }


}
