package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class PatientMapper {
    private static final Logger log = LoggerFactory.getLogger(PatientMapper.class);

    public static PatientResponseDTO toPatientResponseDTO(Patient p){
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setEmail(p.getEmail());
        patientResponseDTO.setFirstName(p.getFirstName());
        patientResponseDTO.setLastName(p.getLastName());
        patientResponseDTO.setGender(p.getGender());
        patientResponseDTO.setPhoneNumber(p.getPhoneNumber());
        patientResponseDTO.setAddress(p.getAddress());
        if (p.getDateOfBirth() != null){
            patientResponseDTO.setDateOfBirth(p.getDateOfBirth().toString());
        }
        patientResponseDTO.setPrivacyConsent(p.isPrivacyConsent());
        if (p.getRegisteredDate() != null){
            patientResponseDTO.setRegisteredDate(p.getRegisteredDate().toString());
        }
        patientResponseDTO.setOccupation(p.getOccupation());
        patientResponseDTO.setInsuranceProvider(p.getInsuranceProvider());
        patientResponseDTO.setInsurancePolicyNumber(p.getInsurancePolicyNumber());
        patientResponseDTO.setAllergies(p.getAllergies());
        patientResponseDTO.setCurrentMedication(p.getCurrentMedication());
        patientResponseDTO.setFamilyMedicalHistory(p.getFamilyMedicalHistory());
        patientResponseDTO.setPastMedicalHistory(p.getPastMedicalHistory());
        patientResponseDTO.setIdentificationType(p.getIdentificationType());
        patientResponseDTO.setIdentificationNumber(p.getIdentificationNumber());
        patientResponseDTO.setIdentificationDocumentUrl(p.getIdentificationDocumentUrl());
        log.info(p.getPrimaryPhysician());
        patientResponseDTO.setPrimaryPhysician(p.getPrimaryPhysician());
        patientResponseDTO.setId(p.getId().toString());
        patientResponseDTO.setUserId(p.getUserId());
        patientResponseDTO.setEmergencyContactName(p.getEmergencyContactName());
        patientResponseDTO.setEmergencyContactNumber(p.getEmergencyContactNumber());

        return patientResponseDTO;
    }

    public static Patient toModel(PatientRequestDTO requestDTO) {
        Patient patient = new Patient();

        patient.setEmail(requestDTO.getEmail());
        patient.setPhoneNumber(requestDTO.getPhoneNumber());
        patient.setFirstName(requestDTO.getFirstName());
        patient.setLastName(requestDTO.getLastName());
        patient.setUserId(requestDTO.getUserId());
        patient.setPrivacyConsent(requestDTO.isPrivacyConsent());
        patient.setGender(requestDTO.getGender());

        // Convert String to LocalDate (if your entity uses LocalDate)
        if (requestDTO.getDateOfBirth() != null) {
            patient.setDateOfBirth(LocalDate.parse(requestDTO.getDateOfBirth()));
        }

        if (requestDTO.getRegisteredDate() != null) {
            patient.setRegisteredDate(LocalDate.parse(requestDTO.getRegisteredDate()));
        }

        patient.setAddress(requestDTO.getAddress());
        patient.setOccupation(requestDTO.getOccupation());
        patient.setEmergencyContactName(requestDTO.getEmergencyContactName());
        patient.setEmergencyContactNumber(requestDTO.getEmergencyContactNumber());
        patient.setInsuranceProvider(requestDTO.getInsuranceProvider());
        patient.setInsurancePolicyNumber(requestDTO.getInsurancePolicyNumber());
        patient.setAllergies(requestDTO.getAllergies());
        patient.setCurrentMedication(requestDTO.getCurrentMedication());
        patient.setFamilyMedicalHistory(requestDTO.getFamilyMedicalHistory());
        patient.setPastMedicalHistory(requestDTO.getPastMedicalHistory());
        patient.setIdentificationType(requestDTO.getIdentificationType());
        patient.setIdentificationNumber(requestDTO.getIdentificationNumber());
        patient.setIdentificationDocumentUrl(requestDTO.getIdentificationDocumentUrl());
        patient.setPrimaryPhysician(requestDTO.getPrimaryPhysician());
        patient.setUserId(requestDTO.getUserId());

        return patient;
    }

    public static void updateEntity(Patient patient, PatientRequestDTO dto) {

        if (dto.getFirstName() != null && !dto.getFirstName().isBlank()) {
            patient.setFirstName(dto.getFirstName());
        }

        if (dto.getLastName() != null && !dto.getLastName().isBlank()) {
            patient.setLastName(dto.getLastName());
        }

        if (dto.getEmail() != null && !dto.getEmail().isBlank()) {
            patient.setEmail(dto.getEmail());
        }

        if (dto.getPhoneNumber() != null && !dto.getPhoneNumber().isBlank()) {
            patient.setPhoneNumber(dto.getPhoneNumber());
        }

        if (dto.getUserId() != null && !dto.getUserId().isBlank()) {
            patient.setUserId(dto.getUserId());
        }

        patient.setPrivacyConsent(dto.isPrivacyConsent());

        if (dto.getGender() != null && !dto.getGender().isBlank()) {
            patient.setGender(dto.getGender());
        }

        if (dto.getDateOfBirth() != null && !dto.getDateOfBirth().isBlank()) {
            patient.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth().substring(0, 10)));
        }

        if (dto.getRegisteredDate() != null && !dto.getRegisteredDate().isBlank()) {
            patient.setRegisteredDate(LocalDate.parse(dto.getRegisteredDate().substring(0, 10)));
        }

        if (dto.getAddress() != null && !dto.getAddress().isBlank()) {
            patient.setAddress(dto.getAddress());
        }

        if (dto.getOccupation() != null && !dto.getOccupation().isBlank()) {
            patient.setOccupation(dto.getOccupation());
        }

        if (dto.getEmergencyContactName() != null && !dto.getEmergencyContactName().isBlank()) {
            patient.setEmergencyContactName(dto.getEmergencyContactName());
        }

        if (dto.getEmergencyContactNumber() != null && !dto.getEmergencyContactNumber().isBlank()) {
            patient.setEmergencyContactNumber(dto.getEmergencyContactNumber());
        }

        if (dto.getInsuranceProvider() != null && !dto.getInsuranceProvider().isBlank()) {
            patient.setInsuranceProvider(dto.getInsuranceProvider());
        }

        if (dto.getInsurancePolicyNumber() != null && !dto.getInsurancePolicyNumber().isBlank()) {
            patient.setInsurancePolicyNumber(dto.getInsurancePolicyNumber());
        }

        if (dto.getAllergies() != null && !dto.getAllergies().isBlank()) {
            patient.setAllergies(dto.getAllergies());
        }

        if (dto.getCurrentMedication() != null && !dto.getCurrentMedication().isBlank()) {
            patient.setCurrentMedication(dto.getCurrentMedication());
        }

        if (dto.getFamilyMedicalHistory() != null && !dto.getFamilyMedicalHistory().isBlank()) {
            patient.setFamilyMedicalHistory(dto.getFamilyMedicalHistory());
        }

        if (dto.getPastMedicalHistory() != null && !dto.getPastMedicalHistory().isBlank()) {
            patient.setPastMedicalHistory(dto.getPastMedicalHistory());
        }

        if (dto.getIdentificationType() != null && !dto.getIdentificationType().isBlank()) {
            patient.setIdentificationType(dto.getIdentificationType());
        }

        if (dto.getIdentificationNumber() != null && !dto.getIdentificationNumber().isBlank()) {
            patient.setIdentificationNumber(dto.getIdentificationNumber());
        }

        if (dto.getIdentificationDocumentUrl() != null && !dto.getIdentificationDocumentUrl().isBlank()) {
            patient.setIdentificationDocumentUrl(dto.getIdentificationDocumentUrl());
        }

        if (dto.getPrimaryPhysician() != null && !dto.getPrimaryPhysician().isBlank()) {
            patient.setPrimaryPhysician(dto.getPrimaryPhysician());
        }
    }
}
