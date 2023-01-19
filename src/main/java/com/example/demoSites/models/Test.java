package com.example.demoSites.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany()
    private ArrayList<Question> questions;

    public Test() {
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                '}';
    }
}
