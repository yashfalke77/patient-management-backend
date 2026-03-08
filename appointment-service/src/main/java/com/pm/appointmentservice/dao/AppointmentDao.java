package com.pm.appointmentservice.dao;

import com.pm.appointmentservice.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentDao extends JpaRepository<Appointment, UUID> {
    List<Appointment> findAllByUserId(String userId);

    Appointment getAppointmentsById(UUID id);
}
