package com.gesieniec.orm_overwiew.service;

import com.gesieniec.orm_overwiew.dto.UserDao;
import com.gesieniec.orm_overwiew.dto.UserDto;
import com.gesieniec.orm_overwiew.entity.GroupEntity;
import com.gesieniec.orm_overwiew.entity.RoleEntity;
import com.gesieniec.orm_overwiew.entity.UserEntity;
import com.gesieniec.orm_overwiew.repository.GroupRepository;
import com.gesieniec.orm_overwiew.repository.RoleRepository;
import com.gesieniec.orm_overwiew.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    UserRepository userRepository;
    RoleRepository roleRepository;
    GroupRepository groupRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.groupRepository = groupRepository;
    }

    public List<UserDto> getAllUsers() {
        final List<UserEntity> allUsers = userRepository.findAll();
        return allUsers.stream().map(UserEntity::toDto).collect(Collectors.toList());
    }

    public void deleteUser(String userEmail) {
        final UserEntity byEmail = userRepository.findByEmail(userEmail);
        userRepository.delete(byEmail);
    }

    @Transactional
    public void addUser(UserDao userDao) {

        final RoleEntity byRoleName = roleRepository.findByRoleName(userDao.getRoleName());
        final UserEntity userEntity = new UserEntity(userDao.getName(), userDao.getSurname(), userDao.getEmail(), byRoleName);

        final List<GroupEntity> allByGroupNameIn = groupRepository.findAllByGroupNameIn(userDao.getGroupNames());
        allByGroupNameIn.forEach(userEntity::addGroup);
        userRepository.save(userEntity);
    }
}
