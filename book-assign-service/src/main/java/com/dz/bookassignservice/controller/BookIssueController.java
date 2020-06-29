package com.dz.bookassignservice.controller;

import com.dz.bookassignservice.model.BookIssue;
import com.dz.bookassignservice.service.BookIssueService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * This is controller that is responsible for operation related to book assignment </br></br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Api(tags = "bookassign")
@RestController
@RequestMapping(value = "/bookIssue")
public class BookIssueController {

    @Autowired
    private BookIssueService bookIssueService;

    /**
     * This method is use to save details of book issue
     * @param bookIssue : {@link BookIssue}
     * @return @{@link BookIssue}
     */
    @PostMapping
    public BookIssue save(@RequestBody BookIssue bookIssue) {
        return this.bookIssueService.save(bookIssue);
    }

    /**
     * this method is use to save list of Book issue details
     * @param bookIssues : List of @{@link BookIssue}
     * @return List of @{@link BookIssue}
     */
    @PostMapping(value = "saveAll")
    public Iterable<BookIssue> saveAll(@RequestBody Iterable<BookIssue> bookIssues) {
        return this.bookIssueService.saveAll(bookIssues);
    }

    /**
     * this is use to update Book issue details
     * @param bookIssue : @{@link BookIssue}
     * @return @{@link BookIssue}
     */
    @PutMapping
    public BookIssue update(@RequestBody BookIssue bookIssue) {
        return this.bookIssueService.update(bookIssue);
    }

    /**
     * This is use get Book issue details by issue id
     * @param id : long
     * @return @{@link BookIssue}
     */
    @GetMapping(value = "/{id}")
    public Optional<BookIssue> getById(@PathVariable long id) {
        return this.bookIssueService.findById(id);
    }

    /**
     * Get All details of Book issued
     * @return List of @{@link BookIssue}
     */
    @GetMapping
    public Iterable<BookIssue> getAll() {
        return this.bookIssueService.findAll();
    }

    /**
     * Delete Book issue details by id
     * @param id : long
     * @return @{@link String}
     */
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable long id) {
        return this.bookIssueService.delete(id);
    }

    /**
     * Permanently Delete Book issue details by id
     * @param id : long
     * @return @{@link String}
     */
    @DeleteMapping(value = "/delete/{id}")
    public String permanenetDelete(@PathVariable long id) {
        return this.bookIssueService.permanentDelete(id);
    }
}
