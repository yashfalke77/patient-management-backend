package com.pm.appointmentservice.dao;

import com.pm.appointmentservice.model.DoctorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorDetailDao extends JpaRepository<DoctorDetail, UUID> {
}
