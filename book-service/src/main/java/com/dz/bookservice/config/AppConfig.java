package com.dz.bookservice.config;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Data
@Component
public class AppConfig {

    @Value(value = "${user-service-base-url}")
    @NotNull
    public String userServiceUrl;
}
