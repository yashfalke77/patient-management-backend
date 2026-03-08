package com.pm.appointmentservice.mapper;

import com.pm.appointmentservice.dto.AppointmentRequestDTO;
import com.pm.appointmentservice.dto.AppointmentResponseDTO;
import com.pm.appointmentservice.dto.AppointmentStatsDTO;
import com.pm.appointmentservice.model.Appointment;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
        appointmentResponseDTO.setCreatedAt(appointment.getCreatedAt().toString());

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                "EEE MMM dd yyyy HH:mm:ss 'GMT'Z", Locale.ENGLISH
        );
        return ZonedDateTime.parse(date.replaceAll(" \\(.*\\)", ""), formatter)
                .withZoneSameInstant(ZoneId.of("Asia/Kolkata"))
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

    public static AppointmentStatsDTO toAppointmentStatusResponseDto(Map<String, Long> counts , List<Appointment> appointmentList){
        AppointmentStatsDTO appointmentStatsDTO = new AppointmentStatsDTO();
        appointmentStatsDTO.setDocuments(appointmentList);
        appointmentStatsDTO.setPendingCount(counts.getOrDefault("pending", 0L));
        appointmentStatsDTO.setScheduledCount(counts.getOrDefault("scheduled", 0L));
        appointmentStatsDTO.setCancelledCount(counts.getOrDefault("cancelled", 0L));
        appointmentStatsDTO.setTotalCount(appointmentList.size());
        return appointmentStatsDTO;
    }
}
