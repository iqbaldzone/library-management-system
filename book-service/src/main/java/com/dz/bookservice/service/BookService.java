package com.dz.bookservice.service;

import com.dz.bookservice.model.Book;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
public interface BookService extends BaseService<Book> {

    Iterable<Book> findAllByTitle(String title);

    Iterable<Book> findAllBySubject(String subject);

    Iterable<Book> findAllByAuthorId(Long authorId);

    Iterable<Book> findAllByPublicationId(Long publicationId);

    Iterable<Book> findAllByDepartmentId(Long departmentId);
}
