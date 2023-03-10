package com.example.demoSites.controllers;


import com.example.demoSites.Services.TrainingService;
import com.example.demoSites.models.Training;
import com.example.demoSites.repo.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    public TrainingRepository trainingRepository;
    @Autowired
    public TrainingService trainingService;


    @GetMapping("/logIn")
    public String logIn(Model model) {
        model.addAttribute("title","Страница авторизации");
        return "logIn";
    }

    @GetMapping("/blog/addTest")
    public String addTest(Model model) {
        model.addAttribute("title","Добавление естирования");
        return "addTest";
    }
    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("title","Страница регистрации");
        return "signUp";
    }
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("title","Главная страница");
        return "home";
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

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String description, @RequestParam String trainer, @RequestParam Integer countPlace, Model model){
        Training training = new Training(title, description, trainer, countPlace);
        if (training.getTitle().isEmpty()){
            return "errors";
        } else {
            trainingRepository.save(training);
            return "redirect:/blog";
        }
    }
    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model){
        if(!trainingRepository.existsById(id)){
            return "redirect:/blog";
        }
        Optional<Training> training = trainingRepository.findById(id);
        ArrayList<Training> resTrain = new ArrayList<>();
        training.ifPresent(resTrain::add);
        model.addAttribute("training",resTrain);
        return "blogDetails";
    }

    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable(value = "id") long id, Model model){
        if(!trainingRepository.existsById(id)){
            return "redirect:/blog";
        }
        Optional<Training> training = trainingRepository.findById(id);
        ArrayList<Training> resTrain = new ArrayList<>();
        training.ifPresent(resTrain::add);
        model.addAttribute("training",resTrain);
        return "blogEdit";
    }

    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String description, @RequestParam String trainer, @RequestParam Integer countPlace, Model model){
       Training training = trainingRepository.findById(id).orElseThrow();
       training.setTitle(title);
       training.setDescription(description);
       training.setTrainer(trainer);
       training.setCountPlace(countPlace);
       trainingRepository.save(training);
        return "redirect:/blog";
    }

    @PostMapping("/blog/{id}/remove")
    public String blogPostDelete(@PathVariable(value = "id") long id, Model model){
        Training training = trainingRepository.findById(id).orElseThrow();
        trainingRepository.delete(training);
        return "redirect:/blog";
    }
}
