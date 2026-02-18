package com.pm.authservice.service;

import com.pm.authservice.dao.UserDao;
import com.pm.authservice.dto.UserRequestDTO;
import com.pm.authservice.dto.UserResponseDTO;
import com.pm.authservice.exception.EmailAlreadyExistsException;
import com.pm.authservice.mapper.UserMapper;
import com.pm.authservice.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserDao userDao;

    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if(userDao.existsByEmail(userRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A user with this email already exists!");
        }

        User user = userDao.save(UserMapper.toModel(userRequestDTO));
        return UserMapper.toDto(user);
    }
}
