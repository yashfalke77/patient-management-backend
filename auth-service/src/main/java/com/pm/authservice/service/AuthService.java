package com.pm.authservice.service;

import com.pm.authservice.dto.LoginRequestDTO;
import com.pm.authservice.dto.UserRequestDTO;
import com.pm.authservice.dto.UserResponseDTO;
import com.pm.authservice.grpc.PatientServiceGrpcClient;
import com.pm.authservice.util.JwtUtil;
import com.pm.proto.PatientResponse;
import io.jsonwebtoken.JwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private static final Logger log = LoggerFactory.getLogger(AuthService.class);
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PatientServiceGrpcClient patientServiceGrpcClient;

    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        log.info("Authenticating user with login request DTO {}", passwordEncoder.matches(loginRequestDTO.getPassword(), loginRequestDTO.getPassword()));
        return userService.findByEmail(loginRequestDTO.getEmail())
                .filter(u -> passwordEncoder.matches(loginRequestDTO.getPassword(), u.getPassword()))
                .map(u -> jwtUtil.generateToken(u.getId().toString(), u.getRole()));
    }

    public boolean validateToken(String token) {
        try {
            jwtUtil.validateToken(token);
            return true;
        } catch (JwtException e){
            return false;
        }
    }

    public UserResponseDTO register(UserRequestDTO userRequestDTO) {
        userRequestDTO.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        userRequestDTO.setRole("PATIENT");
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
        PatientResponse response = patientServiceGrpcClient.createPatient(userResponseDTO.getId(), userResponseDTO.getEmail());
        userResponseDTO.setPatientId(response.getPatientId());
        String token = jwtUtil.generateToken(userResponseDTO.getRole(), userResponseDTO.getId());
        userResponseDTO.setToken(token);
        log.info("setting patient Id in Response {}", userResponseDTO.getPatientId());
        return userResponseDTO;
    }
}
