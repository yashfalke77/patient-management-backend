package com.pm.appointmentservice.mapper;

import com.pm.appointmentservice.model.PatientDetail;
import com.pm.proto.PatientEvent;

import java.time.LocalDate;
import java.util.UUID;

public class PatientDetailMapper {
    public static PatientDetail toModel(PatientEvent patientEvent){
        PatientDetail patientDetail = new PatientDetail();
        patientDetail.setId(UUID.fromString(patientEvent.getId()));
        patientDetail.setEmail(patientEvent.getEmail());
        patientDetail.setDateOfBirth(LocalDate.parse(patientEvent.getDateOfBirth()));
        patientDetail.setUserId(UUID.fromString(patientEvent.getUserId()));
        patientDetail.setFirstName(patientEvent.getFirstName());
        patientDetail.setLastName(patientEvent.getLastName());

        return patientDetail;
    }
}
