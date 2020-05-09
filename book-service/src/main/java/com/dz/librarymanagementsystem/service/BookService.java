package com.dz.librarymanagementsystem.service;

import com.dz.librarymanagementsystem.model.Book;

public interface BookService extends BaseService<Book> {

    Iterable<Book> findAllByTitle(String title);

    Iterable<Book> findAllBySubject(String subject);

    Iterable<Book> findAllByAuthorId(Long authorId);

    Iterable<Book> findAllByPublicationId(Long publicationId);

    Iterable<Book> findAllByDepartmentId(Long departmentId);
}
