package com.forma.training.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "trainers")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String expertise;

    @OneToMany(mappedBy = "trainer")
    private List<Training> trainings = new ArrayList<>();

    // Getters and Setters
}