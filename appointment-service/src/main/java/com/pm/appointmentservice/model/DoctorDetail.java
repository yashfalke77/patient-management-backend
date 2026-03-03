package com.pm.appointmentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class DoctorDetail {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private UUID id;

    @NotNull
    @Size(max=100)
    private String name;

    @NotNull
    @Size(max=100)
    private String specialization;

    @NotNull
    private String consultationFee;

    @NotNull
    private boolean isActive;

    @NotNull
    private Date registeredAt;


}
