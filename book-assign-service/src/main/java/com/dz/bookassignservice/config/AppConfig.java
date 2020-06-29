package com.dz.bookassignservice.config;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * This is configuration class that get config value
 * from properties file </br></br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Component
@Data
public class AppConfig {

    @Value(value = "${user-service-base-url}")
    @NotNull
    public String userServiceUrl;

    @Value(value = "${book-service-base-url}")
    @NotNull
    public String bookServiceUrl;
}
