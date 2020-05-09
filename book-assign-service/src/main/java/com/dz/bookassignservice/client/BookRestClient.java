package com.dz.bookassignservice.client;

import com.dz.bookassignservice.config.AppConfig;
import com.dz.bookassignservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class BookRestClient extends RestClient<Book> {

    @Autowired
    private AppConfig appConfig;

    public ResponseEntity<Book> get(String url) {
        return super.get(appConfig.getBookServiceUrl() + url, Book.class);
    }

    public ResponseEntity<Book> put(String url, Book entity) {
        return super.put(appConfig.getBookServiceUrl() + url, entity, Book.class);
    }

}
