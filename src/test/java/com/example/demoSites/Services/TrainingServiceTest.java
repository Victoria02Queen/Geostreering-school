package com.example.demoSites.Services;

import com.example.demoSites.models.Training;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.management.Query;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
class TrainingServiceTest {
//    @Autowired
//    private TrainingService trainingService;
//
//    @Test
//    void getById() {
//        Training training = new Training("Geolog", "bla","Ivanov", 23);
//        Training savedTraining = trainingService.addTraining(training);
//        Training trainingById = trainingService.getById(savedTraining.getId());
//        Assertions.assertEquals(savedTraining, trainingById);
//    }

//    @Test
//    void editTraining() {
//        Training training = new Training("ASS", "bla","Petrov", 13);
//        trainingService.addTraining(training);
//        training.setTitle("bbb");
//        trainingService.editTraining(training);
//        Training editTraining = trainingService.getById(training.getId());
//        assertEquals(training, editTraining);
//    }
//
//    @Test
//    void deleteTraining() {
//        Training training = new Training("Geolog", "bla","Ivanov", 23);
//        Training savedTraining = trainingService.addTraining(training);
//        Training trainingById = trainingService.getById(savedTraining.getId());
//        assertNotNull(trainingById);
//        trainingService.deleteTraining(trainingById.getId());
//        Training trainingMustBeNull = trainingService.getById(trainingById.getId());
//        assertNull(trainingMustBeNull);
//    }
}