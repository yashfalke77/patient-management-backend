package com.pm.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequestDTO {
    @NotBlank(message = "Email is Required")
    @Email(message = "Email is not Proper")
    private String email;

    @NotBlank(message = "Password is Required")
    private String password;

    private String role;
}
