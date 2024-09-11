package com.forma.training.controller;

import com.forma.training.dto.SessionRequest;
import com.forma.training.model.Session;
import com.forma.training.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Session> getAllSessions() {
        return sessionService.findAllSessions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long id) {
        Optional<Session> session = sessionService.findSessionById(id);
        return session.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/")
    public ResponseEntity<Session> createSession(@RequestBody SessionRequest sessionRequest) {
        Session session = new Session();
        Session createdSession = sessionService.createOrUpdateSession(
                session,
                sessionRequest.getTrainingId(),
                sessionRequest.getStartDate(),
                sessionRequest.getEndDate(),
                sessionRequest.getLocation(),
                sessionRequest.getTrainer()
        );
        return ResponseEntity.ok(createdSession);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Session> updateSession(
            @PathVariable Long id,
            @RequestBody SessionRequest sessionRequest
    ) {
        Optional<Session> existingSession = sessionService.findSessionById(id);
        if (existingSession.isPresent()) {
            Session sessionToUpdate = existingSession.get();
            Session updatedSession = sessionService.updateSession(
                    sessionToUpdate,
                    sessionRequest.getTrainingId(),
                    sessionRequest.getStartDate(),
                    sessionRequest.getEndDate(),
                    sessionRequest.getLocation(),
                    sessionRequest.getTrainer()
            );
            return ResponseEntity.ok(updatedSession);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
        return ResponseEntity.ok().build();
    }
}
