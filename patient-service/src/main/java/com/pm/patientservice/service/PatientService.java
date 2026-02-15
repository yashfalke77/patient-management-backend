package com.pm.patientservice.service;

import com.pm.patientservice.dao.PatientDao;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientDao dao;

    public List<PatientResponseDTO> getPatients(){
        List<Patient>  patients = dao.findAll();
        return patients.stream()
                .map(PatientMapper::toPatientResponseDTO)
                .toList();
    }
}
