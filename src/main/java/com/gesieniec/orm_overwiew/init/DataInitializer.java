package com.gesieniec.orm_overwiew.init;

import com.gesieniec.orm_overwiew.entity.UserEntity;
import com.gesieniec.orm_overwiew.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    @Autowired
    private UserRepository userRepository;

    public void initializeData(){
        initializeUsers();

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
