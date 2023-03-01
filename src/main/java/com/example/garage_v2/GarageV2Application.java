package com.example.garage_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GarageV2Application {

    public static void main(String[] args) {
        SpringApplication.run(GarageV2Application.class, args);
    }

}
