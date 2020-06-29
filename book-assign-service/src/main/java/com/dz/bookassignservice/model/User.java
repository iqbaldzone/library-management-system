package com.dz.bookassignservice.model;

import lombok.Data;

import java.sql.Date;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Data
public class User {

    private Long id;

    private String userName;

    private String role;

    private String firstName;

    private String lastName;

    private String contact;

    private String email;

    private String addres;

    private Boolean deleted = Boolean.FALSE;

    private int booksCapacity;

    private String createdBy;

    private String updatedBy;

    private Date createdDate;

    private Date updatedDate;

    private Date deletedDate;
}
