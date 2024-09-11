package com.forma.training.controller;

import com.forma.training.model.Feedback;
import com.forma.training.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/training/{trainingId}")
    public List<Feedback> getFeedbackByTraining(@PathVariable Long trainingId) {
        return feedbackService.findFeedbackByTrainingId(trainingId);
    }

    @GetMapping("/user/{userId}")
    public List<Feedback> getFeedbackByUser(@PathVariable Long userId) {
        return feedbackService.findFeedbackByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        return ResponseEntity.ok(feedbackService.createFeedback(feedback));
    }
}
