package com.example.demoSites.controllers;

import com.example.demoSites.Services.TestService;
import com.example.demoSites.models.Test;
import com.example.demoSites.repo.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @Autowired
    TestService testService;

    @PostMapping("/test/add")
    public void addTest(@RequestBody Test test){
        testService.addTest(test);
    }
    @GetMapping("/test/get")
    public Test getTestById(@RequestParam Long id){
        return testService.getTestById(id);
    }
    @DeleteMapping("/test/remove")
    public void removeById(@RequestParam Long id){
        testService.removeById(id);
    }
    @PatchMapping("/test/update")
    public void updateTest(@RequestBody Test test){
        testService.updateTest(test);
    }
    @PostMapping("/test/checkAnswers")
    public int checkAnswers(@RequestBody Map<Long, Long> answers){
        return testService.checkTest(answers);
    }
}
