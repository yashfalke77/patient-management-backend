package com.pm.appointmentservice.service;

import com.pm.appointmentservice.dao.DoctorDetailDao;
import com.pm.appointmentservice.dto.DoctorResponseDTO;
import com.pm.appointmentservice.mapper.DoctorDetailMapper;
import com.pm.appointmentservice.model.DoctorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorDetailDao doctorDetailDao;

    public List<DoctorResponseDTO> getDoctors(){
        List<DoctorDetail>  doctorDetails = doctorDetailDao.findAll();
        return doctorDetails.stream().map(DoctorDetailMapper::toResponseDTO).toList();
    }
}
