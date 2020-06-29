package com.dz.bookservice.model;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Data
@MappedSuperclass
public class BaseModel extends IndentityModel{

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String contact;

    private String email;

    private String addres;
}
