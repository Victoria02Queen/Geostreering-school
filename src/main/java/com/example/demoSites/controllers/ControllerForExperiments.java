package com.example.demoSites.controllers;

import com.example.demoSites.controllers.test.TestDao;
import com.example.demoSites.repo.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerForExperiments {
    @Autowired
    TestDao testDao;

    @PostMapping("/completedTraining")
    public void completedTraining(Long userId, Long trainingId, int countOfCorrectAnswer){
        testDao.addCompletedTrainingFosUser(userId, trainingId, countOfCorrectAnswer);
    }

}
