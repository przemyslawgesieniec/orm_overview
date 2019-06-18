package com.gesieniec.orm_overwiew.init;

import com.gesieniec.orm_overwiew.entity.GroupEntity;
import com.gesieniec.orm_overwiew.entity.OrdersEntity;
import com.gesieniec.orm_overwiew.entity.ProductEntity;
import com.gesieniec.orm_overwiew.entity.RoleEntity;
import com.gesieniec.orm_overwiew.entity.UserEntity;
import com.gesieniec.orm_overwiew.repository.GroupRepository;
import com.gesieniec.orm_overwiew.repository.OrdersRepository;
import com.gesieniec.orm_overwiew.repository.ProductRepository;
import com.gesieniec.orm_overwiew.repository.RoleRepository;
import com.gesieniec.orm_overwiew.repository.UserRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {


    //TODO: https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private OrdersRepository ordersRepository;


    public void initializeData() {

        /**
         * ROLES
         */
        RoleEntity roleAdmin = new RoleEntity("Administrator");
        RoleEntity roleUser = new RoleEntity("User");

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        /**
         * PRODUCTS
         */
        ProductEntity product1 = new ProductEntity("Lenovo V130-15", 1500.00);
        ProductEntity product2 = new ProductEntity("Lenovo Ideapad 320-15", 2340.99);
        ProductEntity product3 = new ProductEntity("MSI GL63", 3299.00);
        ProductEntity product4 = new ProductEntity("Apple MacBook Air", 5549.00);
        ProductEntity product5 = new ProductEntity("Acer Aspire 1", 999.00);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);


        /**
         * USERS AND GROUPS
         */

        UserEntity userEntity1 = new UserEntity("Adam", "Adamowicz", "adam.adamowicz@gmail.com", roleAdmin);
        UserEntity userEntity2 = new UserEntity("Michal", "Michalczewski", "michal.michalczewski@gmail.com", roleUser);
        UserEntity userEntity3 = new UserEntity("Lukasz", "Lukaszewicz", "lukasz.lukaszewicz@gmail.com", roleUser);
        UserEntity userEntity4 = new UserEntity("Krzysztof", "Krzryskiewicz", "krzysztof.krzryskiewicz@gmail.com", roleUser);

        GroupEntity groupEntity1 = new GroupEntity("Drone Lovers", "IT’S NOT JUST A HOBBY, ITS A PASSION");
        GroupEntity groupEntity2 = new GroupEntity("My green garden", "All about gardening");
        GroupEntity groupEntity3 = new GroupEntity("BenchGymPro", "For those who really want to know how to bench more");

        groupRepository.save(groupEntity1);
        groupRepository.save(groupEntity2);
        groupRepository.save(groupEntity3);

        userEntity1.addGroup(groupEntity1);
        userEntity1.addGroup(groupEntity2);

        userEntity2.addGroup(groupEntity3);

        userEntity3.addGroup(groupEntity2);
        userEntity3.addGroup(groupEntity3);
        userEntity3.addGroup(groupEntity1);

        userRepository.save(userEntity1);
        userRepository.save(userEntity2);
        userRepository.save(userEntity3);
        userRepository.save(userEntity4);


        /**
         * ORDERS
         */

        OrdersEntity ordersEntity1 = new OrdersEntity(userEntity1, Arrays.asList(product1,product2,product3));
        OrdersEntity ordersEntity2 = new OrdersEntity(userEntity1, Arrays.asList(product4,product3,product3));
        OrdersEntity ordersEntity3 = new OrdersEntity(userEntity2, Arrays.asList(product3));
        OrdersEntity ordersEntity4 = new OrdersEntity(userEntity2, Arrays.asList(product2));
        OrdersEntity ordersEntity5 = new OrdersEntity(userEntity3, Arrays.asList(product1,product2,product3,product5));
        OrdersEntity ordersEntity6 = new OrdersEntity(userEntity4, Arrays.asList(product5,product5,product5));

        ordersRepository.save(ordersEntity1);
        ordersRepository.save(ordersEntity2);
        ordersRepository.save(ordersEntity3);
        ordersRepository.save(ordersEntity4);
        ordersRepository.save(ordersEntity5);
        ordersRepository.save(ordersEntity6);

        /**
         * ASSIGN ORDERS TO USERS
         */

        userEntity1.addOrder(ordersEntity1);
        userEntity1.addOrder(ordersEntity2);
        userEntity1.addOrder(ordersEntity4);
        userEntity2.addOrder(ordersEntity6);
        userEntity2.addOrder(ordersEntity3);
        userEntity3.addOrder(ordersEntity5);
        userEntity4.addOrder(ordersEntity6);
        userEntity4.addOrder(ordersEntity1);


    }

}