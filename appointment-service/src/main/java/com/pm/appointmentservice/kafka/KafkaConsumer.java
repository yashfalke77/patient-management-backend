package com.pm.appointmentservice.kafka;

import com.google.protobuf.InvalidProtocolBufferException;
import com.pm.appointmentservice.dao.PatientDetailDao;
import com.pm.appointmentservice.mapper.PatientDetailMapper;
import com.pm.appointmentservice.model.PatientDetail;
import com.pm.proto.PatientEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

//    @Autowired
//    PatientDetailDao patientDetailDao;
//
//    private static final Logger log = LoggerFactory.getLogger(
//            KafkaConsumer.class);
//
//    @KafkaListener(topics="patient", groupId = "appointment-service")
//    public void consumeEvent(byte[] event) {
//        try {
//            PatientEvent patientEvent = PatientEvent.parseFrom(event);
//
//            log.info("Received Patient Event: [PatientId={},PatientFirstName={}, PatientLastName={},PatientEmail={}, PatientDateOfBirth={}]",
//                    patientEvent.getId(),
//                    patientEvent.getFirstName(),
//                    patientEvent.getLastName(),
//                    patientEvent.getEmail(),
//                    patientEvent.getDateOfBirth());
//
//            patientDetailDao.save(PatientDetailMapper.toModel(patientEvent));
//        } catch (InvalidProtocolBufferException e) {
//            log.error("Error deserializing event {}", e.getMessage());
//        }
//    }
}
