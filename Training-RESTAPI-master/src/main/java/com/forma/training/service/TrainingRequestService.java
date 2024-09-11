package com.forma.training.service;

import com.forma.training.model.TrainingRequest;
import com.forma.training.repository.TrainingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainingRequestService {

    @Autowired
    private TrainingRequestRepository trainingRequestRepository;

    public TrainingRequest createRequest(TrainingRequest request) {
        return trainingRequestRepository.save(request);
    }

    public List<TrainingRequest> findRequestsByUserId(Long userId) {
        return trainingRequestRepository.findByUserId(userId);
    }

    public List<TrainingRequest> findRequestsByTrainingId(Long trainingId) {
        return trainingRequestRepository.findByTrainingId(trainingId);
    }

    public Optional<TrainingRequest> findRequestById(Long id) {
        return trainingRequestRepository.findById(id);
    }

    public void deleteRequest(Long id) {
        trainingRequestRepository.deleteById(id);
    }
}
