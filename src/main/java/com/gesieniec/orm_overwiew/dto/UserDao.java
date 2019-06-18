package com.gesieniec.orm_overwiew.dto;

import lombok.Data;
import java.util.List;

@Data
public class UserDao {

    private String name;
    private String surname;
    private String email;
    private String roleName;
    private List<String> groupNames;
}
