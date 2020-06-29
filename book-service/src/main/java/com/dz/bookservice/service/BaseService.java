package com.dz.bookservice.service;

import com.dz.bookservice.model.IndentityModel;

import java.util.Optional;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
public interface BaseService<T extends IndentityModel> {

    T save(T user);

    T update(T user);

    Optional<T> findById(Long id);

    Iterable<T> findAll();

    String delete(Long id);

    Iterable<T> saveAll(Iterable<T> t);

    String permanentDelete(Long id);
}
