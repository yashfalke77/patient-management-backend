package com.pm.appointmentservice.controller;

import com.pm.appointmentservice.dto.AppointmentRequestDTO;
import com.pm.appointmentservice.dto.AppointmentResponseDTO;
import com.pm.appointmentservice.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<AppointmentResponseDTO>> getAppointmentsByUser(@PathVariable String userId){
        return ResponseEntity.ok().body(appointmentService.getAppointmentsByUser(userId));
    }

    @GetMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponseDTO> getAppointmentById(@PathVariable UUID appointmentId){
        return ResponseEntity.ok().body(appointmentService.getAppointmentById(appointmentId));
    }

    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> createAppointment(@Validated @RequestBody AppointmentRequestDTO appointmentRequestDTO){
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.createAppointment(appointmentRequestDTO);
        return ResponseEntity.ok().body(appointmentResponseDTO);
    }

    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponseDTO> updateAppointment(@PathVariable UUID appointmentId, @Validated @RequestBody AppointmentRequestDTO appointmentRequestDTO){
        AppointmentResponseDTO appointmentResponseDTO = appointmentService.updateAppointment(appointmentRequestDTO, appointmentId);
        return ResponseEntity.ok().body(appointmentResponseDTO);
    }
}
