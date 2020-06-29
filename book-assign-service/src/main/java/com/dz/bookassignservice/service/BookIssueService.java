package com.dz.bookassignservice.service;

import com.dz.bookassignservice.model.BookIssue;

import java.util.Optional;

/**
 * This interface is contain abstract method to book assignment </br></br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
public interface BookIssueService {

    /**
     * This method is use to save details of book issue
     * @param bookIssue : {@link BookIssue}
     * @return @{@link BookIssue}
     */
    BookIssue save(BookIssue bookIssue);

    /**
     * this is use to update Book issue details
     * @param bookIssue : @{@link BookIssue}
     * @return @{@link BookIssue}
     */
    BookIssue update(BookIssue bookIssue);

    /**
     * This is use get Book issue details by issue id
     * @param id : long
     * @return @{@link BookIssue}
     */
    Optional<BookIssue> findById(long id);

    /**
     * Get All details of Book issued
     * @return List of @{@link BookIssue}
     */
    Iterable<BookIssue> findAll();

    /**
     * Delete Book issue details by id
     * @param id : long
     * @return @{@link String}
     */
    String delete(long id);

    /**
     * Permanently Delete Book issue details by id
     * @param id : long
     * @return @{@link String}
     */
    String permanentDelete(long id);

    /**
     * this method is use to save list of Book issue details
     * @param bookIssues : List of @{@link BookIssue}
     * @return List of @{@link BookIssue}
     */
    Iterable<BookIssue> saveAll(Iterable<BookIssue> bookIssues);
}
