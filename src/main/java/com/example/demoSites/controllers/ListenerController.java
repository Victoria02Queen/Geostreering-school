package com.example.demoSites.controllers;

import com.example.demoSites.Services.TestService;
import com.example.demoSites.Services.TrainingService;
import com.example.demoSites.Services.UserService;
import com.example.demoSites.controllers.test.TestDao;
import com.example.demoSites.models.Question;
import com.example.demoSites.models.Test;
import com.example.demoSites.models.Training;
import com.example.demoSites.models.User;
import com.example.demoSites.repo.TrainingRepository;
import com.example.demoSites.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/listener")
public class ListenerController {
    @Autowired
    public TrainingRepository trainingRepository;
    @Autowired
    public TrainingService trainingService;
    @Autowired
    public TestService testService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TestDao testDao;
    @GetMapping("/training")
    public String getAllTrainings(Model model){
        Iterable<Training> trainings = trainingService.getAllTrainings();
        model.addAttribute("trainings",trainings);
        return "TrainingByListener";
    }
    @GetMapping("/account")
    public String getShowAccount(Model model){
        User users = userService.findUserById(2l);
        model.addAttribute("users",users);
        return "accProba";
    }
    @GetMapping("/home")
    public String getShowListener(Model model){
        return "Listener";
    }

    /**
     *
     * @param answers - questionId : answerId
     * @return
     */
    @PostMapping("/checkAnswers")
    public String checkAnswers(@RequestParam Map<String, String> answers, @RequestParam Long trainingId, Model model){
        answers.remove("trainingId");
        Map<Long, Long> longAnswers = new HashMap<>();
        for (Map.Entry<String, String> entry : answers.entrySet()){
            longAnswers.put(Long.parseLong(entry.getKey()), Long.parseLong(entry.getValue()));
        }
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUserByLogin(userDetails.getUsername());
        int results= testService.checkTest(longAnswers, user.getId(),trainingId);
        model.addAttribute("results", results);
        return "resultTest";
    }
    @GetMapping("/passTest")
    public String getTest(Model model){
        Test test = testService.getTestById(150l);
        List<QuestionDto> questionDtoList = new ArrayList<>();
        for (int i = 0; i < test.getQuestions().size() ;i++){
            questionDtoList.add(convertToQuestionDto(test.getQuestions().get(i), i + 1));
        }
        model.addAttribute("questions", questionDtoList);
        model.addAttribute("trainingId", test.getTraining().getId());
        return "passTest";
    }

    private QuestionDto convertToQuestionDto(Question question, int position){
        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(question.getId());
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
