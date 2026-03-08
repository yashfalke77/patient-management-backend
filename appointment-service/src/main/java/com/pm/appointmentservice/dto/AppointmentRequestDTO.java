package com.pm.appointmentservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AppointmentRequestDTO {
    @NotBlank(message="patient id is required")
    private  String patientId;

    @NotBlank(message="schedule is required")
    private String schedule;

    @NotBlank(message = "reason is required")
    @Size(max=1000, message = "reason cannot exceed 1000 chars")
    private String reason;

    @NotBlank(message="doctor id is required")
    private  String doctorId;

    private String status;

    @Size(max=1000, message = "cancellationReason cannot exceed 1000 chars")
    private String cancellationReason;

    @NotBlank(message="user id is required")
    private  String userId;

    @Size(max=1000, message = "note cannot exceed 1000 chars")
    private String note;

    private String patientName;
}
