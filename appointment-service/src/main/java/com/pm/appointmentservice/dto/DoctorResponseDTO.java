package com.pm.appointmentservice.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class DoctorResponseDTO {
    private String id;
    private String name;
    private String specialization;
    private String consultationFee;
    private boolean isActive;
    private String registeredAt;
}
