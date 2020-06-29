package com.dz.bookservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Entity
@Table(name = "departments")
@Data
@EqualsAndHashCode(callSuper = true)
public class Department extends IndentityModel {

    private String name;

    private String admin;

}
