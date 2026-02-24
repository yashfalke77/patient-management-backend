package com.pm.authservice.grpc;

import com.pm.proto.PatientRequest;
import com.pm.proto.PatientResponse;
import com.pm.proto.PatientServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceGrpcClient {
    private static final Logger log = LoggerFactory.getLogger(
            PatientServiceGrpcClient.class);

    private final PatientServiceGrpc.PatientServiceBlockingStub blockingStub;

    public PatientServiceGrpcClient(
            @Value("${patient.service.address:localhost}") String serverAddress,
            @Value("${patient.service.grpc.port:9001}") int serverPort
    ){
        log.info("Connecting to Billing Service GRPC service at {}:{}",
                serverAddress, serverPort);
        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress,
                serverPort).usePlaintext().build();
        blockingStub = PatientServiceGrpc.newBlockingStub(channel);
    }

    public PatientResponse createPatient(String userId, String email){
        PatientRequest request = PatientRequest.newBuilder().setUserId(userId).setEmail(email).build();
        PatientResponse response = blockingStub.createPatient(request);
        log.info("Received response from billing service via GRPC: {}", response);
        return response;
    }

}
