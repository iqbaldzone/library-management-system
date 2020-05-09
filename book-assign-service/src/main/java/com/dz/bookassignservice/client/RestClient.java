package com.dz.bookassignservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestClient<T> {

    @Autowired
    private RestTemplate restTemplate;

    public ResponseEntity<T> get(String url, Class<T> response) {
        try {
            return this.restTemplate.getForEntity(url, response);
        } catch (Exception ex) {
            throw new RuntimeException("");
        }
    }

    public ResponseEntity<T> put(String url, T entity, Class<T> response) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return this.restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<T>(entity, headers), response);
    }
}
