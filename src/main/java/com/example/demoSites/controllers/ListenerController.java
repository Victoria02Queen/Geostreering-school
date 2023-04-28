package com.example.demoSites.controllers;

import com.example.demoSites.Services.TestService;
import com.example.demoSites.Services.TrainingService;
import com.example.demoSites.models.Question;
import com.example.demoSites.models.Test;
import com.example.demoSites.models.Training;
import com.example.demoSites.repo.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/listener")
public class ListenerController {
    @Autowired
    public TrainingRepository trainingRepository;
    @Autowired
    public TrainingService trainingService;
    @Autowired
    public TestService testService;
    @GetMapping("/training")
    public String getAllTrainings(Model model){
        Iterable<Training> trainings = trainingService.getAllTrainings();
        model.addAttribute("trainings",trainings);
        return "TrainingByListener";
    }
    @GetMapping("/account")
    public String getShowAccount(Model model){
        return "account";
    }
    @GetMapping("/home")
    public String getShowListener(Model model){
        return "Listener";
    }

    @GetMapping("/passTest")
    public String getTest(Model model){
        Test test = testService.getTestById(16l);
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (int i = 0; i < test.getQuestions().size() ;i++){
            questionDtoList.add(convertToQuestionDto(test.getQuestions().get(i), i + 1));
        }
        model.addAttribute("questions", questionDtoList);
        return "passTest";
    }

    private QuestionDto convertToQuestionDto(Question question, int position){
        QuestionDto questionDto = new QuestionDto();
        questionDto.setQuestion(question.getQuestion());
        questionDto.setAnswers(question.getAnswers());
        questionDto.setTest(question.getTest());
        questionDto.setPosition(position);
        return questionDto;
    }
    private class QuestionDto extends Question{
        private int position;


        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }
    }
}
