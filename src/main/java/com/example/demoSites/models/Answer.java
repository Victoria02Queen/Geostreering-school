package com.example.demoSites.models;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Boolean correct;
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;
    public Answer() {
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", correct=" + correct +
                '}';
    }
}
