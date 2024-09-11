package com.forma.training.controller;

import com.forma.training.model.TrainingRequest;
import com.forma.training.service.TrainingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/requests")
public class TrainingRequestController {

    @Autowired
    private TrainingRequestService trainingRequestService;

    @GetMapping("/user/{userId}")
    public List<TrainingRequest> getRequestsByUserId(@PathVariable Long userId) {
        return trainingRequestService.findRequestsByUserId(userId);
    }

    @GetMapping("/training/{trainingId}")
    public List<TrainingRequest> getRequestsByTrainingId(@PathVariable Long trainingId) {
        return trainingRequestService.findRequestsByTrainingId(trainingId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingRequest> getRequestById(@PathVariable Long id) {
        Optional<TrainingRequest> request = trainingRequestService.findRequestById(id);
        return request.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TrainingRequest> createRequest(@RequestBody TrainingRequest request) {
        return ResponseEntity.ok(trainingRequestService.createRequest(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRequest(@PathVariable Long id) {
        trainingRequestService.deleteRequest(id);
        return ResponseEntity.ok().build();
    }
}
