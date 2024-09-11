package com.forma.training.repository;

import com.forma.training.model.TrainingRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainingRequestRepository extends JpaRepository<TrainingRequest, Long> {
    List<TrainingRequest> findByUserId(Long userId);
    List<TrainingRequest> findByTrainingId(Long trainingId);
}
