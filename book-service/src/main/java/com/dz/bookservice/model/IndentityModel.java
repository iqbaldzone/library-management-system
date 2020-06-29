package com.dz.bookservice.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.sql.Date;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Data
@MappedSuperclass
public class IndentityModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean deleted = Boolean.FALSE;

    private String createdBy;

    private String updatedBy;

    private Date createdDate;

    private Date updatedDate;

    private Date deletedDate;

}
