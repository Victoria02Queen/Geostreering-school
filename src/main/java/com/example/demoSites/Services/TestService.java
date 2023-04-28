package com.example.demoSites.Services;

import com.example.demoSites.controllers.test.CompletedTrainingDto;
import com.example.demoSites.controllers.test.CreateTestRequest;
import com.example.demoSites.controllers.test.TestDao;
import com.example.demoSites.models.*;
import com.example.demoSites.repo.AnswerRepository;
import com.example.demoSites.repo.QuestionRepository;
import com.example.demoSites.repo.TestRepository;
import com.example.demoSites.repo.TrainingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    private AnswerRepository answerRepository;
    @Autowired
    private TestDao testDao;

    /*Можно создавать сущность в запросе указывая только ее id, речь про training*/
    public Test addTest(CreateTestRequest createTestRequest){
        Training training = trainingRepository.findById(createTestRequest.getTrainingId()).orElse(null);
        if (training == null){
            log.warn("Training with id = {} was not found ", createTestRequest.getTrainingId());
            throw new RuntimeException("training is null");
        }
        Test test = convertToTest(createTestRequest, training);
        Test saveTest = testRepository.save(test);

        List<Answer> answers = new ArrayList<>();

        for (Question question: test.getQuestions()){
            question.setTest(saveTest);
            List<Answer> localAnswers = question.getAnswers();
            question.setAnswers(null);
            Question savedQuestion = questionRepository.save(question);
            localAnswers.forEach(i -> i.setQuestion(savedQuestion));
            answers.addAll(localAnswers);
        }

        questionRepository.saveAll(test.getQuestions());
        // here
        answerRepository.saveAll(answers);
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
    public int checkTest(Map<Long, Long> answers, long userId, long trainingId){
        int countCorrectAnswer = 0;
        for (Map.Entry<Long, Long> entry : answers.entrySet()){
            Question question = questionRepository.findById(entry.getKey()).orElse(null);
            long answerForCheck = entry.getValue();
            long rightAnswerId = getRightAnswerId(question);
            if (answerForCheck == rightAnswerId){
                countCorrectAnswer++;
            }
        }
        testDao.addCompletedTrainingFosUser(userId, trainingId, countCorrectAnswer);
        return countCorrectAnswer;
    }

    public List<CompletedTrainingDto> getAllCompletedTraining(){
        return testDao.getAllCompletedTraining();
    }
}
