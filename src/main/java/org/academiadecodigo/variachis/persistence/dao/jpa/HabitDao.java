package org.academiadecodigo.variachis.persistence.dao.jpa;

import org.academiadecodigo.variachis.persistence.model.Habit;

public class HabitDao extends GenericDao {


    public HabitDao(){
        super(Habit.class);
    }
}
