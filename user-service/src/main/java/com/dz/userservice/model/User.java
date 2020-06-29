package com.dz.userservice.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "user_name")
    private String userName;

    @NotBlank
    private String role;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String contact;

    private String email;

    private String addres;

    private double fees;

    private boolean deleted;

    private String createdBy;

    private String updatedBy;

    private Date createdDate;

    private Date updatedDate;

    private Date deletedDate;

    private int booksCapacity;
}
