package com.gesieniec.orm_overwiew.dto;

import com.gesieniec.orm_overwiew.entity.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import javax.persistence.ManyToMany;
import java.util.List;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GroupDto {

    private String groupName;
    private String description;
    private List<UserDto> users;

}
