package com.dz.bookservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Configuration
public class RestTemplateClient {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
