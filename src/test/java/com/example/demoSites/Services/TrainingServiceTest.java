package com.example.demoSites.Services;

import com.example.demoSites.models.Training;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class TrainingServiceTest {
    @Autowired
    private TrainingService trainingService;

    @Test
    void addTraining() {
        Training training = new Training("Geolog", "bla","Ivanov", 23);
        trainingService.addTraining(training);
    }

    @Test
    void getById() {
        Training training = new Training("Geolog", "bla","Ivanov", 23);
        Training savedTraining = trainingService.addTraining(training);
        Training trainingById = trainingService.getById(savedTraining.getId());
        Assertions.assertEquals(savedTraining, trainingById);
    }

    @Test
    void editTraining() {
    }

    @Test
    void deleteTraining() {
    }
}