package com.forma.training.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@Entity
@Table(name = "training_requests")
public class TrainingRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    private LocalDateTime requestDate;

    // Getters and Setters
}
