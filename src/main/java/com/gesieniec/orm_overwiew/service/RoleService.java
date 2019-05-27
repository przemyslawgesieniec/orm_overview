package com.gesieniec.orm_overwiew.service;

import com.gesieniec.orm_overwiew.dto.RoleDto;
import com.gesieniec.orm_overwiew.entity.RoleEntity;
import com.gesieniec.orm_overwiew.repository.RoleRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleDto> getAllRoles() {
        return roleRepository.findAll().stream().map(RoleEntity::toDto).collect(Collectors.toList());
    }
}
