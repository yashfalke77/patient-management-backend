package com.pm.appointmentservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AppointmentRequestDTO {
    private  String patientId;

    @NotBlank(message="schedule is required")
    private String schedule;

    @Size(max=1000, message = "reason cannot exceed 1000 chars")
    private String reason;

    private  String doctorId;

    private String status;

    @Size(max=1000, message = "cancellationReason cannot exceed 1000 chars")
    private String cancellationReason;

    private  String userId;

    @Size(max=1000, message = "note cannot exceed 1000 chars")
    private String note;

    private String patientName;
}
