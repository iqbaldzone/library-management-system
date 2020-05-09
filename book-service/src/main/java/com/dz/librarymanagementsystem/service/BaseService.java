package com.dz.librarymanagementsystem.service;

import com.dz.librarymanagementsystem.model.IndentityModel;

import java.util.Optional;

public interface BaseService<T extends IndentityModel> {

    T save(T user);

    T update(T user);

    Optional<T> findById(Long id);

    Iterable<T> findAll();

    String delete(Long id);

    Iterable<T> saveAll(Iterable<T> t);

    String permanentDelete(Long id);
}
