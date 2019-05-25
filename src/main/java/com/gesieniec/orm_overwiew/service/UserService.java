package com.gesieniec.orm_overwiew.service;

import com.gesieniec.orm_overwiew.dto.UserDto;
import com.gesieniec.orm_overwiew.entity.UserEntity;
import com.gesieniec.orm_overwiew.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getAllUsers() {
        final List<UserEntity> allUsers = userRepository.findAll();
        return allUsers.stream().map(UserEntity::toDto).collect(Collectors.toList());
    }
}
