package com.dz.bookassignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Main class </br> </br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@SpringBootApplication
@EnableEurekaClient
public class BookAssignServiceApplication {

    /**
     * main method or entry point of application
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BookAssignServiceApplication.class, args);
    }

}
