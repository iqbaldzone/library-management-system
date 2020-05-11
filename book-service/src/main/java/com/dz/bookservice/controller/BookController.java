package com.dz.bookservice.controller;

import com.dz.bookservice.model.Book;
import com.dz.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController extends AbstractBaseController<Book> {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/title/{title}")
    public Iterable<Book> getBooksByTitle(String title) {
        return bookService.findAllByTitle(title);
    }

    @GetMapping(value = "/subject/{subject}")
    public Iterable<Book> getBooksBySubject(String subject) {
        return bookService.findAllBySubject(subject);
    }

    @GetMapping(value = "/authorId/{authorId}")
    public Iterable<Book> getBooksByAuthorId(Long authorId) {
        return bookService.findAllByAuthorId(authorId);
    }

    @GetMapping(value = "publicationId/{publicationId}")
    public Iterable<Book> getBooksByPublicationId(Long publicationId) {
        return bookService.findAllByPublicationId(publicationId);
    }

    @GetMapping(value = "/departmentId/{departmentId}")
    public Iterable<Book> getBooksByDepartmentId(Long departmentId) {
        return bookService.findAllByDepartmentId(departmentId);
    }

    @GetMapping(value = "/available/{id}")
    public int getAvailableBooksById(Long id) {
        return bookService.findById(id).get().getAvailableBooks();
    }
}
