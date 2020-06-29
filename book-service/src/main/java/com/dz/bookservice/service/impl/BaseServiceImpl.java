package com.dz.bookservice.service.impl;

import com.dz.bookservice.dao.BaseDAO;
import com.dz.bookservice.model.IndentityModel;
import com.dz.bookservice.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Optional;

/**
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Service
public class BaseServiceImpl<T extends IndentityModel> implements BaseService<T> {

    @Autowired
    private BaseDAO<T> baseDAO;

    public T save(T t) {
        t.setCreatedDate(new Date(System.currentTimeMillis()));
        return baseDAO.save(t);
    }

    public Iterable<T> saveAll(Iterable<T> t) {
        return baseDAO.saveAll(t);
    }

    public T update(T t) {
        t.setUpdatedDate(new Date(System.currentTimeMillis()));
        return baseDAO.save(t);
    }

    public Optional<T> findById(Long id) {
        return baseDAO.findById(id);
    }

    public Iterable<T> findAll() {
        return baseDAO.findAll();
    }

    public String delete(Long id) {
        T t = this.findById(id).get();
        t.setDeletedDate(new Date(System.currentTimeMillis()));
        t.setDeleted(true);
        baseDAO.save(t);
        return "deleted";
    }

    public String permanentDelete(Long id) {
        baseDAO.deleteById(id);
        return "deleted";
    }
}
