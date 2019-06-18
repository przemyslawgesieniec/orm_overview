package com.gesieniec.orm_overwiew.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    private String groupName;
    private String description;
    private List<UserDto> users;

}
