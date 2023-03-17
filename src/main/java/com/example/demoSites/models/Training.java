package com.example.demoSites.models;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String description;
    private String trainer;
    @Column(name = "count_place")
    private Integer countPlace;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "test_id", referencedColumnName = "id")
    @OneToOne(mappedBy = "training")
    private Test test;

    public Training(String title, String description, String trainer, Integer countPlace) {
        this.title = title;
        this.description = description;
        this.trainer = trainer;
        this.countPlace = countPlace;
    }

    public Integer getCountPlace() {
        return countPlace;
    }

    public void setCountPlace(Integer countPlace) {
        this.countPlace = countPlace;
    }


    public Training() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", trainer='" + trainer + '\'' +
                ", countPlace=" + countPlace +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Training training = (Training) o;
        return Objects.equals(id, training.id) && Objects.equals(title, training.title) && Objects.equals(description, training.description) && Objects.equals(trainer, training.trainer) && Objects.equals(countPlace, training.countPlace) && Objects.equals(test, training.test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, trainer, countPlace, test);
    }
}
