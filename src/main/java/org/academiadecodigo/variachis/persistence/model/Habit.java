package org.academiadecodigo.variachis.persistence.model;


import org.academiadecodigo.variachis.persistence.model.Client;

import javax.persistence.*;

@Entity
@Table(name = "habit")
public class Habit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private boolean smoking;
    private boolean drinking;
    private boolean takeDrugs;
    private boolean riskyJob;
    private boolean sports;
    private boolean bootcampCodeCadet;
    private Integer numberOfMeals;
    private boolean relationship;
    private boolean parent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @OneToOne
    private Client client;

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    public boolean isDrinking() {
        return drinking;
    }

    public void setDrinking(boolean drinking) {
        this.drinking = drinking;
    }

    public boolean isTakeDrugs() {
        return takeDrugs;
    }

    public void setTakeDrugs(boolean takeDrugs) {
        this.takeDrugs = takeDrugs;
    }

    public boolean isRiskyJob() {
        return riskyJob;
    }

    public void setRiskyJob(boolean riskyJob) {
        this.riskyJob = riskyJob;
    }

    public boolean isSports() {
        return sports;
    }

    public void setSports(boolean sports) {
        this.sports = sports;
    }

    public boolean isBootcampCodeCadet() {
        return bootcampCodeCadet;
    }

    public void setBootcampCodeCadet(boolean bootcampCodeCadet) {
        this.bootcampCodeCadet = bootcampCodeCadet;
    }

    public Integer getNumberOfMeals() {
        return numberOfMeals;
    }

    public void setNumberOfMeals(Integer numberOfMeals) {
        this.numberOfMeals = numberOfMeals;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isRelationship() {
        return relationship;
    }

    public void setRelationship(boolean relationship) {
        this.relationship = relationship;
    }

    public boolean isParent() {
        return parent;
    }

    public void setParent(boolean parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Habit{" +
                "smoking=" + smoking +
                ", drinking=" + drinking +
                ", takeDrugs=" + takeDrugs +
                ", riskyJob=" + riskyJob +
                ", sports=" + sports +
                ", bootcampCodeCadet=" + bootcampCodeCadet +
                ", numberOfMeals=" + numberOfMeals +
                ", relationship=" + relationship +
                ", parent=" + parent +
                '}';
    }
}
