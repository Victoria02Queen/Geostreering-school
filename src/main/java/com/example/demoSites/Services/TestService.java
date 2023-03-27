package com.example.demoSites.Services;

import com.example.demoSites.controllers.test.CreateTestRequest;
import com.example.demoSites.models.Answer;
import com.example.demoSites.models.Question;
import com.example.demoSites.models.Test;
import com.example.demoSites.models.Training;
import com.example.demoSites.repo.QuestionRepository;
import com.example.demoSites.repo.TestRepository;
import com.example.demoSites.repo.TrainingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class TestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private TrainingRepository trainingRepository;

    /*Можно создавать сущность в запросе указывая только ее id, речь про training*/
    public Test addTest(CreateTestRequest createTestRequest){
        Training training = trainingRepository.findById(createTestRequest.getTrainingId()).orElse(null);
        if (training == null){
            log.warn("Training with id = {} was not found ", createTestRequest.getTrainingId());
            throw new RuntimeException("training is null");
        }
        Test test = convertToTest(createTestRequest, training);
        Test saveTest = testRepository.save(test);
        for (Question question: test.getQuestions()){
            question.setTest(saveTest);
            question.setAnswers(null);
        }
        questionRepository.saveAll(test.getQuestions());

        return null;
    }
    private Test convertToTest(CreateTestRequest createTestRequest, Training training){
        Test test = new Test();
        test.setTitle(createTestRequest.getTitle());
        test.setQuestions(createTestRequest.getQuestions());
        test.setTraining(training);
        return test;
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
