package com.example.demoSites.controllers;

import com.example.demoSites.controllers.request.FinishTrainingRequest;
import com.example.demoSites.models.User;
import com.example.demoSites.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    public UserRepository userRepository;
    @GetMapping("/user/get")
    public User findUserById(@RequestParam Long id){
        User user = userRepository.findById(id).orElse(null);
        System.out.println(user.getActiveTraining());
        return user;
    }
    @GetMapping("/user/getByLogin")
    public User userByLogin(@RequestParam String login){
        User user = userRepository.findByLogin(login);
        System.out.println(user.getActiveTraining());
        return user;
    }

    public void finishTraining(@RequestBody FinishTrainingRequest finishTrainingRequest){

    }
}
