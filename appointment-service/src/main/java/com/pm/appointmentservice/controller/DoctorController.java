package com.pm.appointmentservice.controller;

import com.pm.appointmentservice.dto.DoctorResponseDTO;
import com.pm.appointmentservice.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorResponseDTO>> getDoctors(){
        return ResponseEntity.ok().body(doctorService.getDoctors());
    }
}
