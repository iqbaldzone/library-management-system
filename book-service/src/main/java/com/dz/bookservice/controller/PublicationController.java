package com.dz.bookservice.controller;

import com.dz.bookservice.model.Publication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@RestController
@RequestMapping(value = "publication")
public class PublicationController extends AbstractBaseController<Publication> {
}
