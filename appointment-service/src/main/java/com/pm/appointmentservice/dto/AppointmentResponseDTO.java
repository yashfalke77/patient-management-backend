package com.pm.appointmentservice.dto;

import lombok.Data;

@Data
public class AppointmentResponseDTO {
    private String id;
    private String patientId;
    private String schedule;
    private String reason;
    private String note;
    private String doctorId;
    private String status;
    private String cancellationReason;
    private String userId;
}
