package com.pm.patientservice.kafka;
import com.pm.patientservice.model.Patient;
import com.pm.proto.PatientEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(
            KafkaProducer.class);
    private final KafkaTemplate<String, byte[]> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, byte[]> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendEvent(Patient patient) {
        try {
            PatientEvent event = PatientEvent.newBuilder()
                    .setId(patient.getId().toString())
                    .setFirstName(patient.getFirstName())
                    .setLastName(patient.getLastName())
                    .setEmail(patient.getEmail())
                    .setDateOfBirth(patient.getDateOfBirth().toString())
                    .setUserId(patient.getUserId())
                    .setEventType("PATIENT_CREATED")
                    .build();

            kafkaTemplate.send("patient", event.toByteArray())
                    .whenComplete((result, ex) -> {
                        if (ex != null) {
                            log.error("Error sending PatientCreated event: {}", ex.getMessage());
                        } else {
                            log.info("PatientCreated event sent successfully for patient id: {}", patient.getId());
                        }
                    });

        } catch (Exception e) {
            log.error("Error building PatientCreated event for patient id {}: {}", patient.getId(), e.getMessage());
        }
    }
}