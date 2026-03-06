package com.pm.appointmentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class PatientDetail {
    @Id
    private UUID id;

    private UUID userId;

    @Email
    @NotNull
    @Size(max=100)
    private String email;

    @NotNull
    @Size(max=100)
    private String firstName;

    @NotNull
    @Size(max=100)
    private String lastName;

    @NotNull
    @Size(max=100)
    private LocalDate dateOfBirth;
}
