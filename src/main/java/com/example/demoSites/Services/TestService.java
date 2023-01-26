package com.example.demoSites.Services;

import com.example.demoSites.controllers.TestController;
import com.example.demoSites.models.Test;
import com.example.demoSites.repo.TestRepository;
import com.example.demoSites.repo.TestRepository2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private TestRepository2 testRepository2;


    public void addTest(Test test){
        testRepository.save(test);
    }

    public Test getTestById(Long id){
        return testRepository.findById(id).orElse(null);
    }

    public void removeById(Long id){
        testRepository.deleteById(id);
    }

    public void updateTest(Test test){
        testRepository.save(test);
    }

    public Iterable<Test> getAll(){
        return testRepository.findAll();
    }

    public int checkTest(Map<Long, Long> answers){
        int countCorrectAnswer = 0;
        for (Map.Entry<Long, Long> entry : answers.entrySet()){
            long rightId = testRepository2.getRightAnswerIdByQuestionId(entry.getKey());
            long answerForCheck = entry.getValue();
            if (answerForCheck == rightId){
                countCorrectAnswer++;
            }
        }
        return countCorrectAnswer;
    }
}
