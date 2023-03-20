package com.example.demoSites.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class CompletedTraining {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Training> training;


    public CompletedTraining() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Training> getTraining() {
        return training;
    }

    public void setTraining(List<Training> training) {
        this.training = training;
    }

    @Override
    public String toString() {
        return "CompletedTraining{" +
                "id=" + id +
                ", training=" + training +
                '}';
    }
}
