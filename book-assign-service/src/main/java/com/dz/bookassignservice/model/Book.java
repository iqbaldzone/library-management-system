package com.dz.bookassignservice.model;

import java.sql.Date;
import lombok.Data;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Data
public class Book {

    private String title;

    private String edition;

    private double price;

    private long authorId;

    private long publicationId;

    private int departmentId;

    private String subject;

    private int noOfBooks;

    private Long id;

    private Boolean deleted = Boolean.FALSE;

    private String createdBy;

    private String updatedBy;

    private Date createdDate;

    private Date updatedDate;

    private Date deletedDate;

    private int availableBooks;

}
