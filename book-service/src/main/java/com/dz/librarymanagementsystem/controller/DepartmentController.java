package com.dz.librarymanagementsystem.controller;

import com.dz.librarymanagementsystem.model.Department;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "department")
public class DepartmentController extends AbstractBaseController<Department> {
}
