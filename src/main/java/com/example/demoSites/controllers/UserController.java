package com.example.demoSites.controllers;

import com.example.demoSites.Services.UserService;
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
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @GetMapping("/user/get")
    public User findUserById(@RequestParam Long id){
        User user = userService.findUserById(id);
        System.out.println(user.getActiveTraining());
        return user;
    }
    @GetMapping("/user/getByLogin")
    public User findUserByLogin(@RequestParam String login){
        User user = userService.findUserByLogin(login);
        System.out.println(user.getActiveTraining());
        return user;
    }

    public void finishTraining(@RequestBody FinishTrainingRequest finishTrainingRequest){

    }
}
