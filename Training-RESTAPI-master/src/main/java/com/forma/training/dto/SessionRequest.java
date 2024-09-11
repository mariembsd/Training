package com.forma.training.dto;

import lombok.Data;

@Data
public class SessionRequest {
    private Long trainingId;
    private String startDate; // Expected format: yyyy-MM-dd
    private String endDate;   // Expected format: yyyy-MM-dd
    private String location;
    private String trainer;
}