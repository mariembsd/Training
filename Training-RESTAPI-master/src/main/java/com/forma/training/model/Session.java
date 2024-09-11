    package com.forma.training.model;

    import com.fasterxml.jackson.annotation.JsonFormat;
    import jakarta.persistence.*;
    import lombok.Data;

    import java.time.LocalDateTime;
    @Data
    @Entity
    @Table(name = "sessions")
    public class Session {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        private LocalDateTime startTime;

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
        private LocalDateTime endTime;

        private String location;  // New field for location
        private String trainer;   // New field for trainer

        @ManyToOne
        @JoinColumn(name = "training_id")
        private Training training;

        // Getters and Settersj
    }
