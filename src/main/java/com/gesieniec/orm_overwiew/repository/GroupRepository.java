package com.gesieniec.orm_overwiew.repository;

import com.gesieniec.orm_overwiew.entity.GroupEntity;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends CrudRepository<GroupEntity, Long> {

    List<GroupEntity> findAll();
    GroupEntity findByGroupName(String name);
    List<GroupEntity> findAllByGroupNameIn(List<String> names);
}
