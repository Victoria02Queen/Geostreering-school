package com.example.demoSites.controllers;

import com.example.demoSites.models.Training;
import com.example.demoSites.repo.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListenerController {
    @Autowired
    public TrainingRepository trainingRepository;
    @GetMapping("/Training")
    public String Training(Model model){
        Iterable<Training> trainings = trainingRepository.findAll();
        model.addAttribute("trainings",trainings);
        return "TrainingByListener";
    }
}
