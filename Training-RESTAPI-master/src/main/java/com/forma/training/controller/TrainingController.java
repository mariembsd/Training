package com.forma.training.controller;

import com.forma.training.model.Training;
import com.forma.training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping
    public List<Training> getAllTrainings() {
        return trainingService.findAllTrainings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Training> getTrainingById(@PathVariable Long id) {
        Optional<Training> training = trainingService.findTrainingById(id);
        return training.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Training> createTraining(@RequestBody Training training) {
        return ResponseEntity.ok(trainingService.createOrUpdateTraining(training));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Training> updateTraining(@PathVariable Long id, @RequestBody Training training) {
        Optional<Training> existingTraining = trainingService.findTrainingById(id);
        if (existingTraining.isPresent()) {
            training.setId(id);
            return ResponseEntity.ok(trainingService.createOrUpdateTraining(training));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        trainingService.deleteTraining(id);
        return ResponseEntity.ok().build();
    }
}
