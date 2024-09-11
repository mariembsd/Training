package com.forma.training.service;

import com.forma.training.model.Session;
import com.forma.training.model.Training;
import com.forma.training.repository.SessionRepository;
import com.forma.training.repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private TrainingRepository trainingRepository;

    public Session updateSession(Session session, Long trainingId, String startDate, String endDate, String location, String trainer) {
        // Convert the date strings to LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime startTime = LocalDate.parse(startDate, formatter).atStartOfDay();
        LocalDateTime endTime = LocalDate.parse(endDate, formatter).atStartOfDay();

        // Update session details
        session.setStartTime(startTime);
        session.setEndTime(endTime);
        session.setLocation(location);
        session.setTrainer(trainer);

        // Update the training link only if needed
        if (trainingId != null) {
            Training training = trainingRepository.findById(trainingId)
                    .orElseThrow(() -> new RuntimeException("Training not found"));
            session.setTraining(training);
        }

        // Save the updated session
        return sessionRepository.save(session);
    }


    public Session createOrUpdateSession(Session session, Long trainingId, String startDate, String endDate, String location, String trainer) {
        // Convert the date strings to LocalDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime startTime = LocalDate.parse(startDate, formatter).atStartOfDay();
        LocalDateTime endTime = LocalDate.parse(endDate, formatter).atStartOfDay();

        // Set session details
        session.setStartTime(startTime);
        session.setEndTime(endTime);
        session.setLocation(location);
        session.setTrainer(trainer);

        // Link the session to a specific training
        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new RuntimeException("Training not found"));
        session.setTraining(training);

        // Save or update the session
        return sessionRepository.save(session);
    }

    public Optional<Session> findSessionById(Long id) {
        return sessionRepository.findById(id);
    }

    public List<Session> findAllSessions() {
        return sessionRepository.findAll();
    }

    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}
