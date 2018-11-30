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
public class ClientToDTO {

    private ClientService clientService;
    private HabitService habitService;
    private ScoreService scoreService;


    @Autowired
    public void setScoreService(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @Autowired
    public void setHabitService(HabitService habitService) {
        this.habitService = habitService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public ClientDto convert(Client client, Habit habit) {


        ClientDto clientDto = new ClientDto();
        //Habit habit = clientService.getHabit(client.getId());

        clientDto.setId(client.getId());
        clientDto.setAge(client.getAge());
        clientDto.setFirstName(client.getFirstName());
        clientDto.setLastName(client.getLastName());
        clientDto.setHeartBeats(client.getHeartBeats());
        clientDto.setHeight(client.getHeight());
        clientDto.setWeight(client.getWeight());


        clientDto.setIdHabit(habit.getId());
        clientDto.setBootcampCodeCadet(habit.isBootcampCodeCadet());
        clientDto.setDrinking(habit.isDrinking());
        clientDto.setNumberOfMeals(habit.getNumberOfMeals());
        clientDto.setParent(habit.isParent());
        clientDto.setRelationship(habit.isRelationship());
        clientDto.setRiskyJob(habit.isRiskyJob());
        clientDto.setSmoking(habit.isSmoking());
        clientDto.setTakeDrugs(habit.isTakeDrugs());
        clientDto.setSports(habit.isSports());

        System.out.println("ClientDto" + client);
        clientDto.setScore(scoreService.totalScore(client.getId()));

        return clientDto;

    }

}
