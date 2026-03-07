package com.pm.appointmentservice.service;

import com.pm.appointmentservice.dao.DoctorDetailDao;
import com.pm.appointmentservice.dto.DoctorResponseDTO;
import com.pm.appointmentservice.mapper.DoctorDetailMapper;
import com.pm.appointmentservice.model.DoctorDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class DoctorService {

    private static final Logger log = LoggerFactory.getLogger(DoctorService.class);
    @Autowired
    DoctorDetailDao doctorDetailDao;

    public List<DoctorResponseDTO> getDoctors(){
        List<DoctorDetail>  doctorDetails = doctorDetailDao.findAll();
        log.error("Inside service {}", doctorDetails.size());
        return doctorDetails.stream().map(DoctorDetailMapper::toResponseDTO).toList();
    }
}
