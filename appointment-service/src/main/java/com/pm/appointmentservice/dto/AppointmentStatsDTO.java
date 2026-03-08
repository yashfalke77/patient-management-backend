package com.pm.appointmentservice.dto;

import com.pm.appointmentservice.model.Appointment;
import lombok.Data;

import java.util.List;

@Data
public class AppointmentStatsDTO {
    private long totalCount;
    private long scheduledCount;
    private long pendingCount;
    private long cancelledCount;
    private List<Appointment> documents;
}
