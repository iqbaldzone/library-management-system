package com.dz.bookassignservice.client;

import com.dz.bookassignservice.config.AppConfig;
import com.dz.bookassignservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * This class is responsible for Communication with Book-service </br></br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Component
public class BookRestClient extends RestClient<Book> {

    @Autowired
    private AppConfig appConfig;

    /**
     * This method is responsible for get Response type of Book from
     * Book-service
     * @param url : URL for service to get Book
     * @return ResponseEntity
     */
    public ResponseEntity<Book> get(String url) {
        return super.get(appConfig.getBookServiceUrl() + url, Book.class);
    }

    /**
     This method is responsible for put Entity type of Book to
     * the Book-service and get response type of Book
     * @param url : URL for service to put Entity
     * @param entity : this book entity to be put
     * @return ResponseEntity
     */
    public ResponseEntity<Book> put(String url, Book entity) {
        return super.put(appConfig.getBookServiceUrl() + url, entity, Book.class);
    }

}
