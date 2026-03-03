package com.pm.appointmentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;

    @NotNull
    private String patientId;

    @NotNull
    private Date schedule;

    @NotNull
    @Size(max=1000)
    private String reason;

    @Size(max=1000)
    private String note;

    @NotNull
    private String doctorId;

    @NotNull
    private String status;

    @Size(max=1000)
    private String cancellationReason;
}
