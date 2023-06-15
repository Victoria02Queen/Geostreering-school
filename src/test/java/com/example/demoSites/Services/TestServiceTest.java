package com.example.demoSites.Services;

import com.example.demoSites.controllers.test.CreateTestRequest;
import com.example.demoSites.models.Answer;
import com.example.demoSites.models.Question;
import com.example.demoSites.models.Training;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
class TestServiceTest {
//
//    @Autowired
//    TrainingService trainingService;
//    @Autowired
//    TestService testService;
//    @Autowired
//    MockMvc mockMvc;
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @Test
//    @Transactional
//    void addTest() {
//
//        Training training = new Training("Geolog", "bla","Ivanov", 23);
//        trainingService.addTraining(training);
//
//        Answer answer = new Answer();
//        answer.setTitle("ok");
//        answer.setCorrect(true);
//
//        Answer answer2 = new Answer();
//        answer2.setTitle("ne ok");
//        answer2.setCorrect(false);
//
//        List<Answer> answerList = new ArrayList<>();
//        answerList.add(answer);
//        answerList.add(answer2);
//        List<Question> questions =  new ArrayList<>();
//
//        Question question = new Question();
//        question.setQuestion("Как дела?");
//        question.setAnswers(answerList);
//        questions.add(question);
//
//        CreateTestRequest createTestRequest = new CreateTestRequest();
//        createTestRequest.setTitle("Geo");
//        createTestRequest.setTrainingId(training.getId());
//        createTestRequest.setQuestions(questions);
//
//
//        com.example.demoSites.models.Test test = testService.addTest(createTestRequest);
//        com.example.demoSites.models.Test saveTest = testService.getTestById(test.getId());
//        System.out.println();
//    }
//
//    @Test
//    void getTestById() {
//
//    }
//
//    @Test
//    void removeById() {
//    }
//
//    @Test
//    void updateTest() {
//    }
//
//    @Test
//    void getAll() {
//    }
//
//    @Test
//    void checkTest() {
//    }
}