package com.dz.bookassignservice.controller;

import com.dz.bookassignservice.model.BookIssue;
import com.dz.bookassignservice.service.BookIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/bookIssue")
public class BookIssueController {

    @Autowired
    private BookIssueService bookIssueService;

    @PostMapping
    public BookIssue save(@RequestBody BookIssue bookIssue) {
        return this.bookIssueService.save(bookIssue);
    }

    @PostMapping(value = "saveAll")
    public Iterable<BookIssue> saveAll(@RequestBody Iterable<BookIssue> bookIssues) {
        return this.bookIssueService.saveAll(bookIssues);
    }

    @PutMapping
    public BookIssue update(@RequestBody BookIssue bookIssue) {
        return this.bookIssueService.update(bookIssue);
    }

    @GetMapping(value = "/{id}")
    public Optional<BookIssue> getById(@PathVariable long id) {
        return this.bookIssueService.findById(id);
    }

    @GetMapping
    public Iterable<BookIssue> getAll() {
        return this.bookIssueService.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable long id) {
        return this.bookIssueService.delete(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String permanenetDelete(@PathVariable long id) {
        return this.bookIssueService.permanentDelete(id);
    }
}
