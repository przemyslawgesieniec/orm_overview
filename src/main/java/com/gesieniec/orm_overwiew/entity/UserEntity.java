package com.gesieniec.orm_overwiew.entity;

import com.gesieniec.orm_overwiew.dto.UserDto;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String email;

    @NonNull
    @OneToOne
    private RoleEntity role;

    @OneToMany(
            mappedBy = "userEntity", //field name in the ordersEntity
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrdersEntity> ordersEntity = new ArrayList<>();

    public UserDto toDto() {
        return new UserDto(name, surname, email, role.toDto());
    }

}
