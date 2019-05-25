package com.gesieniec.orm_overwiew;

import com.gesieniec.orm_overwiew.init.DataInitializer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrmOverviewApplication {


    @Autowired
    private DataInitializer dataInitializer;

    public static void main(String[] args) {
        SpringApplication.run(OrmOverviewApplication.class, args);
    }

    @Bean
    InitializingBean initData() {
        return () -> dataInitializer.initializeData();
    }

}
