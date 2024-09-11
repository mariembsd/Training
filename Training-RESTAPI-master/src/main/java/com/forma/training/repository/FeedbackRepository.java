package com.forma.training.repository;

import com.forma.training.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByTrainingId(Long trainingId);
    List<Feedback> findByUserId(Long userId);
}
