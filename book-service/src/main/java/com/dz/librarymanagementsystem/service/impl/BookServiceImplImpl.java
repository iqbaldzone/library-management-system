package com.dz.librarymanagementsystem.service.impl;

import com.dz.librarymanagementsystem.dao.BookDAO;
import com.dz.librarymanagementsystem.model.Book;
import com.dz.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImplImpl extends BaseServiceImpl<Book> implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Override
    public Book save(Book book) {
        book.setAvailableBooks(book.getNoOfBooks());
        return this.bookDAO.save(book);
    }

    public Iterable<Book> findAllByTitle(String title) {
        return bookDAO.findBooksByTitle(title);
    }

    public Iterable<Book> findAllBySubject(String subject) {
        return bookDAO.findBooksBySubject(subject);
    }

    public Iterable<Book> findAllByAuthorId(Long authorId) {
        return bookDAO.findBooksByAuthorId(authorId);
    }

    public Iterable<Book> findAllByPublicationId(Long publicationId) {
        return bookDAO.findBooksByPublicationId(publicationId);
    }

    public Iterable<Book> findAllByDepartmentId(Long departmentId) {
        return bookDAO.findBooksByDepartment(departmentId);
    }
}
