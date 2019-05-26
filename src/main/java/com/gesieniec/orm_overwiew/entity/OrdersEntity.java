package com.gesieniec.orm_overwiew.entity;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Table(name = "ORDERS")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    /**
     * Bi-directional many-to-one.
     * Join column allows to reefer back to user by the order
     */
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    /**
     * Uni-directional one-to-many.
     * Join column prevents creation of unnecessary join table
     * by letting hibarnate know that there is an foreign key in ProductEntity
     * which defines this association.
     */
    @NonNull
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<ProductEntity> productEntities = new ArrayList<>();
}
