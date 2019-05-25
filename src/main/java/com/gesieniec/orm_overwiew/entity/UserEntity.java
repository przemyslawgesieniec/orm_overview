package com.gesieniec.orm_overwiew.entity;

import com.gesieniec.orm_overwiew.dto.UserDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

//    @OneToOne
//    private ShopEntity shopEntity;
//
//    @OneToMany
//    private OrdersEntity ordersEntity;

    public UserDto toDto(){
        return new UserDto(name,surname,email);
    }

}
