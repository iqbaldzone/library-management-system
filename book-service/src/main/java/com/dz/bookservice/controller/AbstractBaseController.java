package com.dz.bookservice.controller;

import com.dz.bookservice.model.IndentityModel;
import com.dz.bookservice.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
public class AbstractBaseController<T extends IndentityModel> {

    @Autowired
    private BaseService<T> baseService;

    @PostMapping
    public T save(@RequestBody T t) {
        return this.baseService.save(t);
    }

    @PostMapping(value = "saveAll")
    public Iterable<T> saveAll(@RequestBody Iterable<T> t) {
        return this.baseService.saveAll(t);
    }

    @PutMapping
    public T update(@RequestBody T t) {
        return this.baseService.update(t);
    }

    @GetMapping(value = "/{id}")
    public Optional<T> getById(@PathVariable long id) {
        return this.baseService.findById(id);
    }

    @GetMapping
    public Iterable<T> getAll() {
        return this.baseService.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable long id) {
        return this.baseService.delete(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String permanentDelete(@PathVariable long id) {
        return this.baseService.permanentDelete(id);
    }
}
