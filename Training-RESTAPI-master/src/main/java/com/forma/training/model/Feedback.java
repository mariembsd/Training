package com.forma.training.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "feedbacks")
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private Training training;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private LocalDateTime feedbackDate;

    // Getters and Setters
}

