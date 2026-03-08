package com.pm.appointmentservice.mapper;

import com.pm.appointmentservice.dto.AppointmentRequestDTO;
import com.pm.appointmentservice.dto.AppointmentResponseDTO;
import com.pm.appointmentservice.model.Appointment;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class AppointmentMapper {
    public static AppointmentResponseDTO toResponseDTO(Appointment appointment){
        AppointmentResponseDTO appointmentResponseDTO = new AppointmentResponseDTO();
        appointmentResponseDTO.setId(appointment.getId().toString());
        appointmentResponseDTO.setNote(appointment.getNote());
        appointmentResponseDTO.setReason(appointment.getReason());
        appointmentResponseDTO.setSchedule(appointment.getSchedule().toString());
        appointmentResponseDTO.setStatus(appointment.getStatus());
        appointmentResponseDTO.setCancellationReason(appointment.getCancellationReason());
        appointmentResponseDTO.setDoctorId(appointment.getDoctorId());
        appointmentResponseDTO.setUserId(appointment.getUserId());
        appointmentResponseDTO.setPatientId(appointment.getPatientId());

        return appointmentResponseDTO;

    }

    public static Appointment toModel(AppointmentRequestDTO appointmentRequestDTO){
        Appointment appointment = new Appointment();
        appointment.setReason(appointmentRequestDTO.getReason());
        appointment.setNote(appointmentRequestDTO.getNote());
        appointment.setReason(appointmentRequestDTO.getReason());
        if(appointmentRequestDTO.getSchedule()!= null){
            appointment.setSchedule(getParsedDate(appointmentRequestDTO.getSchedule()));
        }
        appointment.setStatus(appointmentRequestDTO.getStatus());
        appointment.setDoctorId(appointmentRequestDTO.getDoctorId());
        appointment.setPatientId(appointmentRequestDTO.getPatientId());
        appointment.setCancellationReason(appointmentRequestDTO.getCancellationReason());
        appointment.setUserId(appointmentRequestDTO.getUserId());

        return appointment;
    }

    public static LocalDateTime getParsedDate(String date) {
        return Instant.parse(date)
                .atZone(ZoneId.of("UTC"))
                .toLocalDateTime();
    }

    public static void updateEntity(Appointment appointment, AppointmentRequestDTO appointmentRequestDTO) {

        if(appointmentRequestDTO!=null &&  !appointmentRequestDTO.getSchedule().isBlank()){
            appointment.setSchedule(getParsedDate(appointmentRequestDTO.getSchedule()));
        }

        if(appointmentRequestDTO!=null && !appointmentRequestDTO.getNote().isBlank()){
            appointment.setNote(appointmentRequestDTO.getNote());
        }

        if(appointmentRequestDTO!=null && !appointmentRequestDTO.getStatus().isBlank()){
            appointment.setStatus(appointmentRequestDTO.getStatus());
        }

        if (appointmentRequestDTO!=null && !appointmentRequestDTO.getReason().isBlank()){
            appointment.setReason(appointmentRequestDTO.getReason());
        }

        if(appointmentRequestDTO != null && !appointmentRequestDTO.getDoctorId().isBlank()){
            appointment.setDoctorId(appointmentRequestDTO.getDoctorId());
        }

        if (appointmentRequestDTO != null && !appointmentRequestDTO.getCancellationReason().isBlank()){
            appointment.setCancellationReason(appointmentRequestDTO.getCancellationReason());
        }

        if (appointmentRequestDTO != null && !appointmentRequestDTO.getPatientId().isBlank()){
            appointment.setPatientId(appointmentRequestDTO.getPatientId());
        }

        if (appointmentRequestDTO!= null && !appointmentRequestDTO.getUserId().isBlank()){
            appointment.setUserId(appointmentRequestDTO.getUserId());
        }
    }
}
