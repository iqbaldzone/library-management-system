package com.dz.librarymanagementsystem.controller;

import com.dz.librarymanagementsystem.model.Publication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "publication")
public class PublicationController extends AbstractBaseController<Publication> {
}
