package com.dz.bookservice.controller;

import com.dz.bookservice.model.Department;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "department")
public class DepartmentController extends AbstractBaseController<Department> {
}
