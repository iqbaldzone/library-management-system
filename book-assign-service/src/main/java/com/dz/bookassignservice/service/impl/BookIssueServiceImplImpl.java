package com.dz.bookassignservice.service.impl;

import com.dz.bookassignservice.client.BookRestClient;
import com.dz.bookassignservice.client.UserRestClient;
import com.dz.bookassignservice.dao.BookIssueDAO;
import com.dz.bookassignservice.model.Book;
import com.dz.bookassignservice.model.BookIssue;
import com.dz.bookassignservice.model.User;
import com.dz.bookassignservice.service.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookIssueServiceImplImpl implements BookIssueService {

    @Autowired
    private BookIssueDAO bookIssueDAO;

    @Autowired
    private BookRestClient bookRestClient;

    @Autowired
    private UserRestClient userRestClient;

    @Override
    public BookIssue save(BookIssue bookIssue) {
        Book book = bookRestClient.get(bookIssue.getBookId().toString()).getBody();
        if (Objects.isNull(book)) {
            throw new RuntimeException("Book not found");
        }
        if (book.getAvailableBooks() == 0) {
            throw new RuntimeException("Book not available to Issue for now");
        }
        User user = userRestClient.get(bookIssue.getIssueTo().toString()).getBody();
        if (Objects.isNull(user)) {
            throw new RuntimeException("User not found");
        }
        if (user.getBooksCapacity() <= bookIssueDAO.booksCountOfUser(bookIssue.getIssueTo())) {
            throw new RuntimeException("User have not capacity: Return first ");
        }
        book.setAvailableBooks(book.getAvailableBooks() - bookIssue.getQuantity());
        ResponseEntity<Book> bookResponse = this.bookRestClient.put("", book);
        if (bookResponse.getStatusCode().isError()) {
            throw new RuntimeException("Fail to Issue the book book of Book Return an error");
        }
        bookIssue.setIssueTime(new Timestamp(System.currentTimeMillis()));
        return bookIssueDAO.save(bookIssue);
    }

    @Override
    public Iterable<BookIssue> saveAll(Iterable<BookIssue> bookIssues) {
        return this.bookIssueDAO.saveAll(bookIssues);
    }

    @Override
    public BookIssue update(BookIssue bookIssue) {
        if (bookIssue.isReturned()) {
            Book book = bookRestClient.get(bookIssue.getBookId().toString()).getBody();
            if (Objects.isNull(book)) {
                throw new RuntimeException("Book not found");
            }
            book.setAvailableBooks(book.getAvailableBooks() + bookIssue.getQuantity());
            bookRestClient.put("", book);
        }
        bookIssue.setReturnTime(new Timestamp(System.currentTimeMillis()));
        return bookIssueDAO.save(bookIssue);
    }

    @Override
    public Optional<BookIssue> findById(long id) {
        return bookIssueDAO.findById(id);
    }

    @Override
    public Iterable<BookIssue> findAll() {
        return bookIssueDAO.findAll();
    }

    @Override
    public String delete(long id) {
        BookIssue bookIssue = this.findById(id).get();
        bookIssue.setDeleted(true);
        bookIssue.setDeletedTime(new Timestamp(System.currentTimeMillis()));
        bookIssueDAO.save(bookIssue);
        return "deleted";
    }

    @Override
    public String permanentDelete(long id) {
        bookIssueDAO.deleteById(id);
        return "deleted";
    }

}
