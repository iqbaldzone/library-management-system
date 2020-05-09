package com.dz.bookassignservice.config;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Value(value = "${user-service-base-url}")
    @NotNull
    public String userServiceUrl;

    @Value(value = "${book-service-base-url}")
    @NotNull
    public String bookServiceUrl;

    public String getUserServiceUrl() {
        return userServiceUrl;
    }

    public void setUserServiceUrl(String userServiceUrl) {
        this.userServiceUrl = userServiceUrl;
    }

    public String getBookServiceUrl() {
        return bookServiceUrl;
    }

    public void setBookServiceUrl(String bookServiceUrl) {
        this.bookServiceUrl = bookServiceUrl;
    }
}
