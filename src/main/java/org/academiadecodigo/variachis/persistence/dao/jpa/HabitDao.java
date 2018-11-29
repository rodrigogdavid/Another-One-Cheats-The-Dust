package org.academiadecodigo.variachis.persistence.dao.jpa;

import org.academiadecodigo.variachis.persistence.model.Habit;
import org.springframework.stereotype.Repository;


@Repository
public class HabitDao extends GenericDao<Habit> {


    public HabitDao() {
        super(Habit.class);
    }
}
