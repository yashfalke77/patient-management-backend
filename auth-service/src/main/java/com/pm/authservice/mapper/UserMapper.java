package com.pm.authservice.mapper;

import com.pm.authservice.dto.UserRequestDTO;
import com.pm.authservice.dto.UserResponseDTO;
import com.pm.authservice.model.User;

public class UserMapper {
    public static User toModel(UserRequestDTO UserRequestDTO){
        User user = new User();
        user.setEmail(UserRequestDTO.getEmail());
        user.setPassword(UserRequestDTO.getPassword());
        user.setRole(UserRequestDTO.getRole());
        return user;
    }

    public static UserResponseDTO toDto(User u){
        UserResponseDTO dto = new UserResponseDTO();
        dto.setId(u.getId().toString());
        dto.setEmail(u.getEmail());
        dto.setPassword(u.getPassword());
        dto.setRole(u.getRole());
        return dto;
    }
}
