package com.pm.appointmentservice.service;

import com.pm.appointmentservice.dao.AppointmentDao;
import com.pm.appointmentservice.dto.AppointmentRequestDTO;
import com.pm.appointmentservice.dto.AppointmentResponseDTO;
import com.pm.appointmentservice.mapper.AppointmentMapper;
import com.pm.appointmentservice.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
