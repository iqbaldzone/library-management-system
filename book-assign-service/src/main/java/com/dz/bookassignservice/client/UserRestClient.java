package com.dz.bookassignservice.client;

import com.dz.bookassignservice.config.AppConfig;
import com.dz.bookassignservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserRestClient extends RestClient<User> {

    @Autowired
    private AppConfig appConfig;

    public ResponseEntity<User> get(String url) {
        return super.get(appConfig.getUserServiceUrl() + url, User.class);
    }

    public ResponseEntity<User> put(String url, User entity) {
        return super.put(appConfig.getUserServiceUrl() + url, entity, User.class);
    }
}
