package com.dz.bookassignservice.client;

import com.dz.bookassignservice.config.AppConfig;
import com.dz.bookassignservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for Communication with User-service </br></br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Component
public class UserRestClient extends RestClient<User> {

    @Autowired
    private AppConfig appConfig;

    /**
     * This method is responsible for get Response type of User from
     * User-service
     * @param url : URL for service to get User
     * @return ResponseEntity
     */
    public ResponseEntity<User> get(String url) {
        return super.get(appConfig.getUserServiceUrl() + url, User.class);
    }

    /**
     This method is responsible for put Entity type of User to
     * the User-service and get response type of User
     * @param url : URL for service to put Entity
     * @param entity : this User entity to be put
     * @return ResponseEntity
     */
    public ResponseEntity<User> put(String url, User entity) {
        return super.put(appConfig.getUserServiceUrl() + url, entity, User.class);
    }
}
