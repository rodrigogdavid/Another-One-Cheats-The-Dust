package org.academiadecodigo.variachis.services;


import org.academiadecodigo.variachis.persistence.dao.jpa.ClientDao;
import org.academiadecodigo.variachis.persistence.dao.jpa.HabitDao;
import org.academiadecodigo.variachis.persistence.model.Client;
import org.academiadecodigo.variachis.persistence.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HabitService {


    private HabitDao habitDao;
    private ClientDao clientDao;


    @Autowired
    public void setHabitDao(HabitDao habitDao) {
        this.habitDao = habitDao;
    }
    @Autowired
    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    public Habit get(Integer id){
        return habitDao.findById(id);
    }

    @Transactional
    public Habit save (Habit habit){

        return habitDao.saveOrUpdate(habit);
    }


    public Integer habitScore(Integer id){
        Integer score = 0;

        Client client = clientDao.findById(id);

        Habit habit = client.getHabit();

        if(habit.isDrinking()){
            score += 1;
        }

        if(habit.isParent()){
            score += 1;
        }

        if(habit.isBootcampCodeCadet()){
            score += 3;
        }

        if (habit.isRiskyJob()){
            score += 1;
        }

        if (habit.isSmoking()){
            score += 1;
        }

        if (habit.isRelationship()){
            score += 1;
        }

        if(!habit.isSports()){
            score += 1;
        }


        if(habit.isTakeDrugs()){
            score += 3;
        }

        if(habit.getNumberOfMeals() < 5){
            score += 1;
        }

        //habitDao.saveOrUpdate(habit);
        return score;
    }


}
