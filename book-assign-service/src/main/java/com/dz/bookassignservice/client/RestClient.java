package com.dz.bookassignservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

/**
 * This class is responsible for Communication with other service
 * like book-service and user-service
 * @param <T> </br></br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
public class RestClient<T> {

    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * This method is responsible for get Response type of <T> from
     * given url
     * @param url : URL for service to get response
     * @param response : Type of response
     * @return @{@link ResponseEntity}
     */
    public ResponseEntity<T> get(String url, Class<T> response) {
        try {
            return this.restTemplate.getForEntity(url, response);
        } catch (Exception ex) {
            throw new RuntimeException("");
        }
    }

    /**
     * This method is responsible for put Entity type of <T> to
     * given url and get response type of <T>
     * @param url : URL for service to put Entity
     * @param entity : Entity that to be put
     * @param response : Type of response
     * @return @{@link ResponseEntity}
     */
    public ResponseEntity<T> put(String url, T entity, Class<T> response) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return this.restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<T>(entity, headers), response);
    }
}
