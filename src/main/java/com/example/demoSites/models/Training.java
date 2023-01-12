package com.example.demoSites.models;

import jakarta.persistence.*;

@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private String description;
    private String trainer;

    public Training(String title, String description, String trainer) {
        this.title = title;
        this.description = description;
        this.trainer = trainer;
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
}
