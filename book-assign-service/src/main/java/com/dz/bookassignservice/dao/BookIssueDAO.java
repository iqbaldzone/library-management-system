package com.dz.bookassignservice.dao;

import com.dz.bookassignservice.model.BookIssue;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookIssueDAO extends CrudRepository<BookIssue, Long> {

    @Query(value = "select count(*) from BookIssue bi where bi.issueTo = :userId group by bi.issueTo")
    int booksCountOfUser(Long userId);
}
