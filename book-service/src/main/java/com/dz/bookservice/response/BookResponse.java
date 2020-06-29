package com.dz.bookservice.response;

import com.dz.bookservice.model.Author;
import com.dz.bookservice.model.Book;
import com.dz.bookservice.model.Publication;
import com.dz.bookservice.model.Department;
import lombok.Data;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Data
public class BookResponse extends Book {

    private Author author;

    private Publication publication;

    private Department department;
}
