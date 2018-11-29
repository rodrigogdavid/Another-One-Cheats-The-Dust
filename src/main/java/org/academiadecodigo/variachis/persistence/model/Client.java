package org.academiadecodigo.variachis.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Integer heartBeats;
    private Integer score;

    @OneToOne(
            cascade = {CascadeType.ALL},
            orphanRemoval = true,
            mappedBy = "client",
            fetch = FetchType.EAGER
    )
    private Habit habit;

    //Setters

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setHearthBeats(Integer hearthBeats) {
        this.heartBeats = hearthBeats;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }

    //Getters
    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getHearthBeats() {
        return heartBeats;
    }

    public Integer getScore() {
        return score;
    }

    public Habit getHabit() {
        return habit;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", hearthBeats=" + heartBeats +
                ", score=" + score +
                ", habit=" + habit +
                '}';
    }
}
