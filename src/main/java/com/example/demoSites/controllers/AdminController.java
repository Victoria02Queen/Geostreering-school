package com.example.demoSites.controllers;


import com.example.demoSites.Services.TrainingService;
import com.example.demoSites.models.Answer;
import com.example.demoSites.models.Training;
import com.example.demoSites.repo.AnswerRepository;
import com.example.demoSites.repo.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    public TrainingRepository trainingRepository;
    @Autowired
    public AnswerRepository answerRepository;
    @Autowired
    public TrainingService trainingService;



    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title","Главная страница");
        return "home";
    }
    @GetMapping("/statistics")
    public String statistics(Model model) {

        return "statisticsAdmin";
    }
    @GetMapping("/blog")
    public String blogMain(Model model){
        Iterable<Training> trainings = trainingRepository.findAll();
        model.addAttribute("trainings",trainings);
        return "blogMain";
    }
    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blogAdd";
    }
    @GetMapping("/blog/addTest")
    public String blogAddTest(Model model){
        return "test";
    }

    @PostMapping("/blog/add")
    public String addTraining(@RequestParam String title, @RequestParam String description, @RequestParam String trainer, @RequestParam Integer countPlace, Model model){
        Training training = new Training(title, description, trainer, countPlace);
        if (training.getTitle().isEmpty()){
            return "errors";
        } else {
            trainingService.addTraining(training);
            return "redirect:/admin/blog";
        }
    }
    @GetMapping("/blog/{id}")
    public String trainingDetails(@PathVariable(value = "id") long id, Model model){
       Training training = trainingService.getById(id);
        if(training == null){
            return "redirect:/admin/blog";
        }
        ArrayList<Training> resTrain = new ArrayList<>();
        resTrain.add(training);
        model.addAttribute("training",resTrain);
        return "blogDetails";
    }

    @GetMapping("/blog/{id}/edit")
    public String editTrainingPage(@PathVariable(value = "id") long id, Model model){
        Training training = trainingService.getById(id);
        if(training == null){
            return "redirect:/admin/blog";
        }
        ArrayList<Training> resTrain = new ArrayList<>();
        resTrain.add(training);
        model.addAttribute("training",resTrain);
        return "blogEdit";
    }

    @PostMapping("/blog/{id}/edit")
    public String editTraining(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description, @RequestParam String trainer, @RequestParam Integer countPlace, Model model){
        Training training = new Training(title,description,trainer,countPlace);
        training.setId(id);
       trainingService.editTraining(training);
        return "redirect:/admin/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String deleteTraining(@PathVariable(value = "id") long id, Model model){
        trainingService.deleteTraining(id);
        return "redirect:/admin/blog";
    }
}
