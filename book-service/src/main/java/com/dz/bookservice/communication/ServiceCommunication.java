package com.dz.bookservice.communication;

import com.dz.bookservice.config.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
public class ServiceCommunication {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppConfig appConfig;

    public HttpStatus getUserResponse(List<String> recordsList) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        ResponseEntity<String> result = this.restTemplate.exchange(appConfig.getUserServiceUrl(), HttpMethod.GET, new HttpEntity<Object>(recordsList, headers), String.class);
        return result.getStatusCode();
    }
}
