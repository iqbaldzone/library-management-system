package com.dz.bookassignservice.service;

import com.dz.bookassignservice.model.BookIssue;

import java.util.Optional;

public interface BookIssueService {

    BookIssue save(BookIssue bookIssue);

    BookIssue update(BookIssue bookIssue);

    Optional<BookIssue> findById(long id);

    Iterable<BookIssue> findAll();

    String delete(long id);

    String permanentDelete(long id);

    Iterable<BookIssue> saveAll(Iterable<BookIssue> bookIssues);
}
