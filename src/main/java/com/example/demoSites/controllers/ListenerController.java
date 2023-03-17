package com.example.demoSites.controllers;

import com.example.demoSites.Services.TrainingService;
import com.example.demoSites.models.Training;
import com.example.demoSites.repo.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/listener")
public class ListenerController {
    @Autowired
    public TrainingRepository trainingRepository;
    @Autowired
    public TrainingService trainingService;
    @GetMapping("/training")
    public String getAllTrainings(Model model){
        Iterable<Training> trainings = trainingService.getAllTrainings();
        model.addAttribute("trainings",trainings);
        return "TrainingByListener";
    }
}
