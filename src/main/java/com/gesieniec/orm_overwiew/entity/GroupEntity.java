package com.gesieniec.orm_overwiew.entity;

import com.gesieniec.orm_overwiew.dto.GroupDto;
import com.gesieniec.orm_overwiew.dto.UserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Table(name = "GROUPS")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String groupName;

    @NonNull
    private String description;

    //todo add photo

    @ManyToMany(mappedBy = "groupList")
    private List<UserEntity> userEntityList;

    public GroupDto toDto(){

        final List<UserDto> usersInGroup = userEntityList
                .stream()
                .map(UserEntity::toDto)
                .collect(Collectors.toList());

        return new GroupDto(groupName,description,usersInGroup);
    }

    public GroupDto toDtoForUser(){
        return new GroupDto(groupName,description,null);
    }

}
