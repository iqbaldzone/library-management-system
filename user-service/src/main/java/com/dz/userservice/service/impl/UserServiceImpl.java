package com.dz.userservice.service.impl;

import com.dz.userservice.dao.UserDAO;
import com.dz.userservice.model.User;
import com.dz.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User save(User user) {
        if (Objects.nonNull(this.findByEmail(user.getEmail()))) {
            throw new RuntimeException(String.format("%s email is already exist", user.getEmail()));
        }
        user.setCreatedDate(new Date(System.currentTimeMillis()));
        return userDAO.save(user);
    }

    @Override
    public User update(User user) {
        user.setUpdatedDate(new Date(System.currentTimeMillis()));
        return userDAO.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public Iterable<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public String delete(Long id) {
        User user = this.findById(id).get();
        user.setDeleted(true);
        user.setDeletedDate(new Date(System.currentTimeMillis()));
        userDAO.save(user);
        return "deleted";
    }

    @Override
    public String permanentDelete(Long id) {
        userDAO.deleteById(id);
        return "deleted";
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    @Override
    public Iterable<User> findByName(String name) {
        return userDAO.findByName(name);
    }
}
