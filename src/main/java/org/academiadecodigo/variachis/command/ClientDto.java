package org.academiadecodigo.variachis.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ClientDto {

    private Integer id;
    private Integer idHabit;

    @NotNull(message = "First name is mandatory")
    @NotBlank(message = "First name is mandatory")
    @Size(min = 3, max = 64)
    private String firstName;

    @NotNull(message = "Last name is mandatory")
    @NotBlank(message = "Last name is mandatory")
    @Size(min = 3, max = 64)
    private String lastName;


    private Integer age;


    private Integer height;
    private Integer weight;
    private Integer heartBeats;
    private Integer score;
    private boolean smoking;
    private boolean drinking;
    private boolean takeDrugs;
    private boolean riskyJob;
    private boolean sports;
    private boolean bootcampCodeCadet;
    private Integer numberOfMeals;
    private boolean relationship;
    private boolean parent;

    public Integer getIdHabit() {
        return idHabit;
    }

    public void setIdHabit(Integer idHabit) {
        this.idHabit = idHabit;
    }

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeartBeats() {
        return heartBeats;
    }

    public void setHeartBeats(Integer heartBeats) {
        this.heartBeats = heartBeats;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ClientDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", heartBeats=" + heartBeats +
                ", score=" + score +
                '}';
    }
}
