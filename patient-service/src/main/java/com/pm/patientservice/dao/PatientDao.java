package com.pm.patientservice.dao;

import com.pm.patientservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientDao extends JpaRepository<Patient, UUID> {
}
