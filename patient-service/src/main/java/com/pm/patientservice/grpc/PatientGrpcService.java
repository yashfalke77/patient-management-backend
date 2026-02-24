package com.pm.patientservice.grpc;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.service.PatientService;
import com.pm.proto.PatientRequest;
import com.pm.proto.PatientResponse;
import com.pm.proto.PatientServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class PatientGrpcService extends PatientServiceGrpc.PatientServiceImplBase {

    private static final Logger log = LoggerFactory.getLogger(PatientGrpcService.class);

    @Autowired
    private PatientService patientService;

    @Override
    public void createPatient(PatientRequest request, StreamObserver<PatientResponse> responseObserver) {
        log.info("Received request for patient: {}", request.getUserId());

        // Creating New Patient
        PatientRequestDTO patientRequestDTO = new PatientRequestDTO();
        patientRequestDTO.setEmail(request.getEmail());
        patientRequestDTO.setUserId(request.getUserId());

        PatientResponseDTO patientResponseDTO = patientService.createPatient(patientRequestDTO);

        PatientResponse response = PatientResponse.newBuilder()
                .setPatientId(patientResponseDTO.getId())
                .setEmail(patientResponseDTO.getEmail())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}