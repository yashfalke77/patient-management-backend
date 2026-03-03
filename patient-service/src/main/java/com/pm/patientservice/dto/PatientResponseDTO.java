package com.pm.patientservice.dto;

import lombok.Data;

@Data
public class PatientResponseDTO {
    private String Id;

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

    private String emergencyContactName;

    private String emergencyContactNumber;

    private String insuranceProvider;

    private String insurancePolicyNumber;

    private String allergies;

    private String currentMedication;

    private String familyMedicalHistory;

    private String pastMedicalHistory;

    private String identificationType;

    private String identificationNumber;

    private String identificationDocumentUrl;

    private String primaryPhysician;
}
