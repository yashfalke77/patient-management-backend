package com.pm.patientservice.dto;

import lombok.Data;

@Data
public class PatientResponseDTO {
    private String email;

    private String phoneNumber;

    private String firstName;

    private String lastName;

    private String userId;

    private boolean privacyConsent;

    private String gender;

    private String dateOfBirth;

    private String registeredDate;

    private String address;

    private String occupation;

    private String emergencyContact;

    private String insuranceProvider;

    private String insurancePolicyNo;

    private String allergies;

    private String currentMedication;

    private String FamilyMedicalHistory;

    private String pastMedicalHistory;

    private String identificationType;

    private String identificationNumber;

    private String identificationDocumentUrl;

    private String PrimaryPhysician;
}
