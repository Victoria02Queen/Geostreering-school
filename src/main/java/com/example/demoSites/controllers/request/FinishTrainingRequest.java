package com.example.demoSites.controllers.request;

public class FinishTrainingRequest {
    private Long userID;
    private Long trainingId;

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }
}
