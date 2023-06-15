package com.example.demoSites.Services;

import com.example.demoSites.models.Training;
import com.example.demoSites.repo.TrainingDao;
import com.example.demoSites.repo.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;
    @Autowired
    private TrainingDao trainingDao;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Training addTraining(Training training){
        return trainingRepository.save(training);
    }

    public Training getById(long id){
        Optional<Training> training = trainingRepository.findById(id);
        return training.orElse(null);
    }

    public void editTraining(Training training){
//        Training training = trainingRepository.findById(id).orElseThrow();
//        training.setTitle(title);
//        training.setDescription(description);
//        training.setTrainer(trainer);
//        training.setCountPlace(countPlace);

        trainingRepository.save(training);
    }
    public void deleteTraining(long id){
        trainingDao.deleteTraining(id);
    }
    public List<Training> getAllTrainings(){
        ArrayList<Training> trainings = new ArrayList<>();
        trainingRepository.findAll().forEach(trainings :: add);
        return trainings;
    }
}
