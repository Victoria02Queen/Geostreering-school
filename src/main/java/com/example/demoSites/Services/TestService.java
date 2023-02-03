package com.example.demoSites.Services;

import com.example.demoSites.controllers.TestController;
import com.example.demoSites.models.Answer;
import com.example.demoSites.models.Question;
import com.example.demoSites.models.Test;
import com.example.demoSites.repo.QuestionRepository;
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
    private QuestionRepository questionRepository;


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

    private long getRightAnswerId(Question question){
        for (Answer answer : question.getAnswers()){
            if (answer.getCorrect()){
                return answer.getId();
            }
        }
        return -1;
    }
    public int checkTest(Map<Long, Long> answers){
        int countCorrectAnswer = 0;
        for (Map.Entry<Long, Long> entry : answers.entrySet()){
            Question question = questionRepository.findById(entry.getKey()).orElse(null);
            long answerForCheck = entry.getValue();
            long rightAnswerId = getRightAnswerId(question);
            if (answerForCheck == rightAnswerId){
                countCorrectAnswer++;
            }
        }
        return countCorrectAnswer;
    }
}
