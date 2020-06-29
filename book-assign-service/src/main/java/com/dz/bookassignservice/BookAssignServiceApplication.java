package com.dz.bookassignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Main class </br> </br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class BookAssignServiceApplication {

    /**
     * main method or entry point of application
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(BookAssignServiceApplication.class, args);
    }

    /**
     * This is swagger configuration for api expose
     * @return
     */
    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.dz.bookassignservice")).build();
    }

}
