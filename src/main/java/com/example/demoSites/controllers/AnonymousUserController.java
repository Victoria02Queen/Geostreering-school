package com.example.demoSites.controllers;

import com.example.demoSites.Services.UserService;
import com.example.demoSites.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/anonymous")
public class AnonymousUserController {
    @Autowired
    private UserService userService;
    @GetMapping("/registration")
    private String userRegistration(@RequestParam(required = false) String fullName, @RequestParam(required = false) String position, @RequestParam(required = false) String organization, @RequestParam String login,@RequestParam String password, @RequestParam(required = false) String phone, @RequestParam(required = false) String email){
        userService.addUser(fullName, position, organization, login, password, phone, email);
        return "redirect:/";
    }
    @GetMapping("/login")
    public String logIn(Model model) {
        model.addAttribute("title","Страница авторизации");
        return "logIn";
    }
    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("title","Страница регистрации");
        return "signUp";
    }

}
