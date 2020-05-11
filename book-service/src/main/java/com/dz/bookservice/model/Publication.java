package com.dz.bookservice.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "publications")
@Data
@EqualsAndHashCode(callSuper = true)
public class Publication extends IndentityModel {

    private String name;

    private String registrationNo;
}
