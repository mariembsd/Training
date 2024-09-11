package com.forma.training.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "trainings")
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @OneToMany(mappedBy = "training")
    private List<Session> sessions = new ArrayList<>();

    // Getters and Setters
}
