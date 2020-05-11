package com.dz.bookservice.controller;

import com.dz.bookservice.model.Author;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "author")
public class AuthorController extends AbstractBaseController<Author> {
}
