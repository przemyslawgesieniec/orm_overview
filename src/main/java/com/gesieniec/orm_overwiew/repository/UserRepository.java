package com.gesieniec.orm_overwiew.repository;

import com.gesieniec.orm_overwiew.entity.UserEntity;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    List<UserEntity> findAll();
}
