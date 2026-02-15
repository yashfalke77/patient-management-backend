package com.pm.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientRequestDTO {
    @NotBlank(message = "Email is required")
    @Email(message = "Email is Invalid")
    private String email;

    @NotBlank(message = "phoneNumber is required")
    private String phoneNumber;

    @NotBlank(message = "firstName is required")
    @Size(max=100 , message = "firstName cannot exceed 100 characters")
    private String firstName;

    @NotBlank(message = "lastName is required")
    @Size(max=100 , message = "lastName cannot exceed 100 characters")
    private String lastName;

    @NotBlank(message = "userId is required")
    private String userId;

    @NotBlank(message = "privacyConsent is required")
    private boolean privacyConsent;

    private String gender;

    private String dateOfBirth;

    private String registeredDate;

    @Size(max=100, message = "address cannot exceed 100 characters")
    private String address;

    @Size(max=100, message = "occupation cannot exceed 100 characters")
    private String occupation;

    @Size(max=100, message = "emergencyContact cannot exceed 100 characters")
    private String emergencyContact;

    @Size(max=100, message = "insuranceProvider cannot exceed 100 characters")
    private String insuranceProvider;

    @Size(max=100, message = "insurancePolicyNo cannot exceed 100 characters")
    private String insurancePolicyNo;

    @Size(max=100, message = "allergies cannot exceed 100 characters")
    private String allergies;

    @Size(max=100)
    private String currentMedication;

    @Size(max=100, message = "FamilyMedicalHistory cannot exceed 100 characters")
    private String FamilyMedicalHistory;

    @Size(max=100, message = "pastMedicalHistory cannot exceed 100 characters")
    private String pastMedicalHistory;

    @Size(max=100, message = "identificationType cannot exceed 100 characters")
    private String identificationType;

    @Size(max=100,  message = "identificationNumber cannot exceed 100 characters")
    private String identificationNumber;

    private String identificationDocumentUrl;

    @Size(max=100, message = "PrimaryPhysician cannot exceed 100 characters")
    private String PrimaryPhysician;
}
