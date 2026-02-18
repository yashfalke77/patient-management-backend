package com.pm.authservice.dto;

import lombok.Data;

@Data
public class UserResponseDTO {
    private String id;

    private String email;

    private String password;

    private String role;
}
