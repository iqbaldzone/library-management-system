package com.dz.bookservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Entity
@Table(name = "books")
@Data
@EqualsAndHashCode(callSuper = true)
public class Book extends IndentityModel {

    @NotBlank
    private String title;

    private String edition;

    private double price;

    @Column(name = "author_id")
    private long authorId;

    @Column(name = "publication_id")
    private long publicationId;

    @Column(name = "department_id")
    private int departmentId;

    private String subject;

    @Column(name = "no_of_books")
    private int noOfBooks;

    @Column(name = "available_books")
    private int availableBooks;
}
