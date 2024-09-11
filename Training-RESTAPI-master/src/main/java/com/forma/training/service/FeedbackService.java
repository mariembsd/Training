package com.forma.training.service;

import com.forma.training.model.Feedback;
import com.forma.training.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback createFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> findFeedbackByTrainingId(Long trainingId) {
        return feedbackRepository.findByTrainingId(trainingId);
    }

    public List<Feedback> findFeedbackByUserId(Long userId) {
        return feedbackRepository.findByUserId(userId);
    }
}
