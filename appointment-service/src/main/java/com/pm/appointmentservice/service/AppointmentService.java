package com.pm.appointmentservice.service;

import com.pm.appointmentservice.dao.AppointmentDao;
import com.pm.appointmentservice.dto.AppointmentRequestDTO;
import com.pm.appointmentservice.dto.AppointmentResponseDTO;
import com.pm.appointmentservice.exception.AppointmentNotFoundException;
import com.pm.appointmentservice.mapper.AppointmentMapper;
import com.pm.appointmentservice.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    AppointmentDao appointmentDao;

    public List<AppointmentResponseDTO> getAppointmentsByUser(String userId){
        List<Appointment> appointments = appointmentDao.findAllByUserId(userId);
        return appointments.stream().map(AppointmentMapper::toResponseDTO).toList();
    }

    public  AppointmentResponseDTO createAppointment(AppointmentRequestDTO appointmentRequestDTO){
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
}
