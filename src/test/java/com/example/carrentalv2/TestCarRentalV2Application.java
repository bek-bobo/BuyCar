package com.example.carrentalv2;

import org.springframework.boot.SpringApplication;

public class TestCarRentalV2Application {

    public static void main(String[] args) {
        SpringApplication.from(CarRentalV2Application::main).with(TestcontainersConfiguration.class).run(args);
    }

}
