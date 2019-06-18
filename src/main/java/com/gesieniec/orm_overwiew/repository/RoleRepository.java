package com.gesieniec.orm_overwiew.repository;

import com.gesieniec.orm_overwiew.entity.RoleEntity;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<RoleEntity, Long> {

    List<RoleEntity> findAll();
    RoleEntity findByRoleName(String roleName);
}
