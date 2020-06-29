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

/**
 * This is service that is responsible for operation related to book assignment </br></br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Service
public class BookIssueServiceImplImpl implements BookIssueService {

    @Autowired
    private BookIssueDAO bookIssueDAO;

    @Autowired
    private BookRestClient bookRestClient;

    @Autowired
    private UserRestClient userRestClient;

    /**
     * This method is use to save details of book issue
     * @param bookIssue : {@link BookIssue}
     * @return @{@link BookIssue}
     */
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

    /**
     * this method is use to save list of Book issue details
     * @param bookIssues : List of @{@link BookIssue}
     * @return List of @{@link BookIssue}
     */
    @Override
    public Iterable<BookIssue> saveAll(Iterable<BookIssue> bookIssues) {
        return this.bookIssueDAO.saveAll(bookIssues);
    }

    /**
     * this is use to update Book issue details
     * @param bookIssue : @{@link BookIssue}
     * @return @{@link BookIssue}
     */
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

    /**
     * This is use get Book issue details by issue id
     * @param id : long
     * @return @{@link BookIssue}
     */
    @Override
    public Optional<BookIssue> findById(long id) {
        return bookIssueDAO.findById(id);
    }

    /**
     * Get All details of Book issued
     * @return List of @{@link BookIssue}
     */
    @Override
    public Iterable<BookIssue> findAll() {
        return bookIssueDAO.findAll();
    }

    /**
     * Delete Book issue details by id
     * @param id : long
     * @return @{@link String}
     */
    @Override
    public String delete(long id) {
        BookIssue bookIssue = this.findById(id).get();
        bookIssue.setDeleted(true);
        bookIssue.setDeletedTime(new Timestamp(System.currentTimeMillis()));
        bookIssueDAO.save(bookIssue);
        return "deleted";
    }

    /**
     * Permanently Delete Book issue details by id
     * @param id : long
     * @return @{@link String}
     */
    @Override
    public String permanentDelete(long id) {
        bookIssueDAO.deleteById(id);
        return "deleted";
    }

}
