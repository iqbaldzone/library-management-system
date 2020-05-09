package com.dz.librarymanagementsystem.dao;

import com.dz.librarymanagementsystem.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookDAO extends BaseDAO<Book> {

    @Query(value = "from Book b where b.title like %:title%")
    Iterable<Book> findBooksByTitle(String title);

    @Query(value = "from Book b where b.subject like %:subject%")
    Iterable<Book> findBooksBySubject(String subject);

    @Query(value = "from Book b where b.departmentId = :departmentId")
    Iterable<Book> findBooksByDepartment(Long departmentId);

    @Query(value = "from Book b where b.authorId = :authorId")
    Iterable<Book> findBooksByAuthorId(Long authorId);

    @Query(value = "from Book b where b.publicationId = :publicationId")
    Iterable<Book> findBooksByPublicationId(Long publicationId);
}
