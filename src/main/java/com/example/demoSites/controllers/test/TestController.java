package com.example.demoSites.controllers.test;

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
    public void addTest(@RequestBody CreateTestRequest createTestRequest){

        testService.addTest(createTestRequest);
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

    /**
     *
     * @param answers - questionId : answerId
     * @return
     */
    @PostMapping("/test/checkAnswers")
    public int checkAnswers(@RequestBody Map<Long, Long> answers){
        return testService.checkTest(answers);
    }

}
