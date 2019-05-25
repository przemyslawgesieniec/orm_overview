package com.gesieniec.orm_overwiew.init;

import com.gesieniec.orm_overwiew.entity.ProductEntity;
import com.gesieniec.orm_overwiew.entity.UserEntity;
import com.gesieniec.orm_overwiew.repository.ProductRepository;
import com.gesieniec.orm_overwiew.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {


    //TODO: https://vladmihalcea.com/the-best-way-to-map-a-onetomany-association-with-jpa-and-hibernate/

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public void initializeData(){
        initializeUsers();
        initializeProducts();

    }

    private void initializeProducts() {
        ProductEntity product1 = new ProductEntity("Lenovo V130-15",1500.00);
        ProductEntity product2 = new ProductEntity("Lenovo Ideapad 320-15",2340.99);
        ProductEntity product3 = new ProductEntity("MSI GL63",3299.00);
        ProductEntity product4 = new ProductEntity("Apple MacBook Air",5549.00);
        ProductEntity product5 = new ProductEntity("Acer Aspire 1",999.00);

        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
    }

    private void initializeUsers(){
        UserEntity userEntity1 = new UserEntity("Adam","Adamowicz","adam.adamowicz@gmail.com");
        UserEntity userEntity2 = new UserEntity("Michal","Michalczewski","michal.michalczewski@gmail.com");
        UserEntity userEntity3 = new UserEntity("Lukasz","Lukaszewicz","lukasz.lukaszewicz@gmail.com");
        UserEntity userEntity4 = new UserEntity("Krzysztof","Krzryskiewicz","krzysztof.krzryskiewicz@gmail.com");

        userRepository.save(userEntity1);
        userRepository.save(userEntity2);
        userRepository.save(userEntity3);
        userRepository.save(userEntity4);
    }
}
