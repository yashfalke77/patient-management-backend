package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

public class PatientMapper {
    public static PatientResponseDTO toPatientResponseDTO(Patient p){
        PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
        patientResponseDTO.setEmail(p.getEmail());
        patientResponseDTO.setFirstName(p.getFirstName());
        patientResponseDTO.setLastName(p.getLastName());
        patientResponseDTO.setGender(p.getGender());
        patientResponseDTO.setPhoneNumber(p.getPhoneNumber());
        patientResponseDTO.setAddress(p.getAddress());
        patientResponseDTO.setDateOfBirth(p.getDateOfBirth().toString());
        patientResponseDTO.setPrivacyConsent(p.isPrivacyConsent());
        patientResponseDTO.setRegisteredDate(p.getRegisteredDate().toString());
        patientResponseDTO.setOccupation(p.getOccupation());
        patientResponseDTO.setEmergencyContact(p.getEmergencyContact());
        patientResponseDTO.setInsuranceProvider(p.getInsuranceProvider());
        patientResponseDTO.setInsurancePolicyNo(p.getInsurancePolicyNo());
        patientResponseDTO.setAllergies(p.getAllergies());
        patientResponseDTO.setCurrentMedication(p.getCurrentMedication());
        patientResponseDTO.setFamilyMedicalHistory(p.getFamilyMedicalHistory());
        patientResponseDTO.setPastMedicalHistory(p.getPastMedicalHistory());
        patientResponseDTO.setIdentificationType(p.getIdentificationType());
        patientResponseDTO.setIdentificationNumber(p.getIdentificationNumber());
        patientResponseDTO.setIdentificationDocumentUrl(p.getIdentificationDocumentUrl());
        patientResponseDTO.setPrimaryPhysician(p.getPrimaryPhysician());

        return patientResponseDTO;
    }
}
