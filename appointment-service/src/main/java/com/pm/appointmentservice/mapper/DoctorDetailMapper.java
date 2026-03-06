package com.pm.appointmentservice.mapper;

import com.pm.appointmentservice.dto.DoctorResponseDTO;
import com.pm.appointmentservice.model.DoctorDetail;

public class DoctorDetailMapper {
    public static DoctorResponseDTO toResponseDTO(DoctorDetail doctorDetail){
        DoctorResponseDTO doctorResponseDTO = new DoctorResponseDTO();
        doctorResponseDTO.setName(doctorDetail.getName());
        doctorResponseDTO.setId(doctorDetail.getId().toString());
        doctorResponseDTO.setActive(doctorDetail.isActive());
        doctorResponseDTO.setSpecialization(doctorDetail.getSpecialization());
        doctorResponseDTO.setRegisteredAt(doctorDetail.getRegisteredAt().toString());

        return doctorResponseDTO;

    }
}
