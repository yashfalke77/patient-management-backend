package com.pm.appointmentservice.service;

import com.pm.appointmentservice.dao.AppointmentDao;
import com.pm.appointmentservice.dao.PatientDetailDao;
import com.pm.appointmentservice.dto.AppointmentRequestDTO;
import com.pm.appointmentservice.dto.AppointmentResponseDTO;
import com.pm.appointmentservice.dto.AppointmentStatsDTO;
import com.pm.appointmentservice.exception.AppointmentNotFoundException;
import com.pm.appointmentservice.mapper.AppointmentMapper;
import com.pm.appointmentservice.model.Appointment;
import com.pm.appointmentservice.model.PatientDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    AppointmentDao appointmentDao;

    @Autowired
    PatientDetailDao patientDetailDao;

    public List<AppointmentResponseDTO> getAppointmentsByUser(String userId){
        List<Appointment> appointments = appointmentDao.findAllByUserId(userId);
        return appointments.stream().map(AppointmentMapper::toResponseDTO).toList();
    }

    public  AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO){
        patientDetailDao.findById(UUID.fromString(appointmentRequestDTO.getPatientId()))
                .map(p -> p.getFirstName() + " " + p.getLastName())
                .ifPresentOrElse(
                        appointmentRequestDTO::setPatientName,
                        () -> appointmentRequestDTO.setPatientName("Patient User")
                );

        Appointment createAppointment = appointmentDao.save(AppointmentMapper.toModel(appointmentRequestDTO));
        return AppointmentMapper.toResponseDTO(createAppointment);
    }

    public AppointmentResponseDTO updateAppointment(AppointmentRequestDTO appointmentRequestDTO, UUID appointmentId){
        Appointment appointment = appointmentDao.findById(appointmentId).orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + appointmentId));
        AppointmentMapper.updateEntity(appointment, appointmentRequestDTO);
        Appointment updatedAppointment = appointmentDao.save(appointment);
        return AppointmentMapper.toResponseDTO(appointment);
    }

    public AppointmentResponseDTO getAppointmentById(UUID appointmentId){
        Appointment appointment = appointmentDao.getAppointmentsById(appointmentId);
        return AppointmentMapper.toResponseDTO(appointment);
    }

    public AppointmentStatsDTO getRecentAppointments() {
        List<Appointment> appointments = appointmentDao.findAllByOrderByCreatedAtDesc();

        Map<String, Long> counts = appointments.stream()
                .collect(Collectors.groupingBy(
                        Appointment::getStatus,
                        Collectors.counting()
                ));

        return AppointmentMapper.toAppointmentStatusResponseDto(counts, appointments);

    }
}
