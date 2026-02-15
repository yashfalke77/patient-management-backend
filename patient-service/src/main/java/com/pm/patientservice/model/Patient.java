package com.pm.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Email
    @Column(unique = true)
    @Size(max=100)
    private String email;

    @NotNull
    private String phoneNumber;

    @NotNull
    @Size(max=100)
    private String firstName;

    @NotNull
    @Size(max=100)
    private String lastName;

    @NotNull
    private String userId;

    @NotNull
    private boolean privacyConsent;

    private String gender;

    private LocalDate dateOfBirth;

    private LocalDate registeredDate;

    @Size(max=100)
    private String address;

    @Size(max=100)
    private String occupation;

    @Size(max=100)
    private String emergencyContact;

    @Size(max=100)
    private String insuranceProvider;

    @Size(max=100)
    private String insurancePolicyNo;

    @Size(max=100)
    private String allergies;

    @Size(max=100)
    private String currentMedication;

    @Size(max=100)
    private String FamilyMedicalHistory;

    @Size(max=100)
    private String pastMedicalHistory;

    @Size(max=100)
    private String identificationType;

    @Size(max=100)
    private String identificationNumber;

    private String identificationDocumentUrl;

    @Size(max=100)
    private String PrimaryPhysician;
}
