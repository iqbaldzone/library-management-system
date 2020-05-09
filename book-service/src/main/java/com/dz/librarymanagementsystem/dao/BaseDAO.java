package com.dz.librarymanagementsystem.dao;

import com.dz.librarymanagementsystem.model.IndentityModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface BaseDAO<T extends IndentityModel> extends CrudRepository<T, Long> {
}
