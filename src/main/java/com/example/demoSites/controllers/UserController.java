package com.example.demoSites.controllers;

import com.example.demoSites.Services.TestService;
import com.example.demoSites.Services.UserService;
import com.example.demoSites.controllers.request.FinishTrainingRequest;
import com.example.demoSites.models.User;
import com.example.demoSites.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestService testService;
    @Autowired
    private UserService userService;
    @GetMapping("/user/get")
    public User findUserById(@RequestParam Long id){
        User user = userService.findUserById(id);
        return user;
    }
    @GetMapping("/user/getByLogin")
    public User findUserByLogin(@RequestParam String login){
        User user = userService.findUserByLogin(login);
        return user;
    }
    public void finishTraining(@RequestBody FinishTrainingRequest finishTrainingRequest){

    }
}
