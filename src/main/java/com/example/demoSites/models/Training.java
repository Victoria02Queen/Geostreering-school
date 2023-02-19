package com.example.demoSites.models;


import jakarta.persistence.*;

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

}
