package com.example.demoSites.controllers.test;

import com.example.demoSites.models.Question;

import java.util.List;

public class CreateTestRequest {
    private String title;
    private List<Question> questions;
    private Long trainingId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    @Override
    public String toString() {
        return "CreateTestRequest{" +
                "title='" + title + '\'' +
                ", questions=" + questions +
                ", trainingId=" + trainingId +
                '}';
    }
}
