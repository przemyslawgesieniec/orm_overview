package com.gesieniec.orm_overwiew.entity;

import com.gesieniec.orm_overwiew.dto.GroupDto;
import com.gesieniec.orm_overwiew.dto.OrdersDto;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
            mappedBy = "userEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrdersEntity> orderList = new LinkedList<>();

    @ManyToMany
    @JoinTable(
            name = "USER_GROUP",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    private List<GroupEntity> groupList = new LinkedList<>();


    public void addOrder(OrdersEntity order){
        orderList.add(order);
    }

    public void addGroup(GroupEntity group){
        groupList.add(group);
    }

    public UserDto toDto() {
        final List<GroupDto> userGroups = groupList
                .stream()
                .map(GroupEntity::toDtoForUser)
                .collect(Collectors.toList());

        final List<OrdersDto> userOrders = orderList
                .stream()
                .map(OrdersEntity::toDto)
                .collect(Collectors.toList());

        return new UserDto(name, surname, email, role.toDto(), userGroups, userOrders);
    }

}
