package org.academiadecodigo.variachis.services;


import org.academiadecodigo.variachis.persistence.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {


    private ClientService clientService;
    private HabitService habitService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setHabitService(HabitService habitService) {
        this.habitService = habitService;
    }


    @Transactional
    public Integer totalScore(Integer id){
        Integer total = 0;

         Client client = clientService.get(id);

        total = clientService.clientScore(id) + habitService.habitScore(id);

        client.setScore(total);

        clientService.save(client);

        return total;

    }
}
