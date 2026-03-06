package com.pm.appointmentservice.dao;

import com.pm.appointmentservice.model.PatientDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientDetailDao extends JpaRepository<PatientDetail, UUID> {
}
