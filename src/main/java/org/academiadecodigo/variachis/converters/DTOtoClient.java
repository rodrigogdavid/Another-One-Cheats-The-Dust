package org.academiadecodigo.variachis.converters;

import org.academiadecodigo.variachis.command.ClientDto;
import org.academiadecodigo.variachis.persistence.model.Client;
import org.academiadecodigo.variachis.persistence.model.Habit;
import org.academiadecodigo.variachis.services.ClientService;
import org.academiadecodigo.variachis.services.HabitService;
import org.academiadecodigo.variachis.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DTOtoClient {

    private ClientService clientService;
    private ScoreService scoreService;
    private HabitService habitService;
    //private Integer idClient = 4;
    //private Integer idHabit = 4;

    @Autowired
    public void setHabitService(HabitService habitService) {
        this.habitService = habitService;
    }

    @Autowired
    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public Client convert(ClientDto clientDto) {

        //Client client = (clientDto.getId() != null ? clientService.get(clientDto.getId()) : new Client());

        Client client = clientService.findByName(clientDto.getFirstName(), clientDto.getLastName());

        if (client == null) {
            client = new Client();
        }
        Habit habit = clientDto.getId() != null ? habitService.get(clientDto.getId()) : new Habit();


        System.out.println("\n\t\t" + clientDto + "\n\n");

        client.setAge(clientDto.getAge());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setHeartBeats(clientDto.getHeartBeats());
        client.setHeight(clientDto.getHeight());
        client.setWeight(clientDto.getWeight());

        System.out.println("\n\t\t" + client + "\n\n");


        habit.setBootcampCodeCadet(clientDto.isBootcampCodeCadet());
        habit.setDrinking(clientDto.isDrinking());
        habit.setNumberOfMeals(clientDto.getNumberOfMeals());
        habit.setParent(clientDto.isParent());
        habit.setRelationship(clientDto.isRelationship());
        habit.setRiskyJob(clientDto.isRiskyJob());
        habit.setSmoking(clientDto.isSmoking());
        habit.setTakeDrugs(clientDto.isTakeDrugs());
        habit.setSports(clientDto.isSports());

        //client.setHabit(habit);
        client = clientService.save(client);
        client.setHabit(habit);
        habit.setId(client.getId());
        habit = habitService.save(habit);
        System.out.println("*************************DTOtoClient habit = " + habit);

        System.out.println("Dto Client " + client);
        scoreService.totalScore(client.getId());


        return client;

    }
}

    /*public Client convertCreate(ClientDto clientDto) {

        Client client = new Client();

        client.setId(idClient);

        Habit habit = new Habit();

        habit.setId(idHabit);

        clientService.save(client);

        client.setAge(clientDto.getAge());
        client.setFirstName(clientDto.getFirstName());
        client.setLastName(clientDto.getLastName());
        client.setHeartBeats(clientDto.getHeartBeats());
        client.setHeight(clientDto.getHeight());
        client.setWeight(clientDto.getWeight());


        habit.setBootcampCodeCadet(clientDto.isBootcampCodeCadet());
        habit.setDrinking(clientDto.isDrinking());
        habit.setNumberOfMeals(clientDto.getNumberOfMeals());
        habit.setParent(clientDto.isParent());
        habit.setRelationship(clientDto.isRelationship());
        habit.setRiskyJob(clientDto.isRiskyJob());
        habit.setSmoking(clientDto.isSmoking());
        habit.setTakeDrugs(clientDto.isTakeDrugs());
        habit.setSports(clientDto.isSports());

        client.setHabit(habit);
        scoreService.totalScore(client.getId());


        return client;

    }
}*/
