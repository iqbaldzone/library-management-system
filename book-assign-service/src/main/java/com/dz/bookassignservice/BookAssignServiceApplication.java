package com.dz.bookassignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookAssignServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookAssignServiceApplication.class, args);
    }

}
