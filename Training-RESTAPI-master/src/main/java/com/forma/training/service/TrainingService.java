package com.forma.training.service;

import com.forma.training.model.Training;
import com.forma.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public Training createOrUpdateTraining(Training training) {
        return trainingRepository.save(training);
    }

    public Optional<Training> findTrainingById(Long id) {
        return trainingRepository.findById(id);
    }

    public List<Training> findAllTrainings() {
        return trainingRepository.findAll();
    }

    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }
}
