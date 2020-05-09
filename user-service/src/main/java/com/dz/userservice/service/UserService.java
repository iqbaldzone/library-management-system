package com.dz.userservice.service;


import com.dz.userservice.model.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    User update(User user);

    Optional<User> findById(Long id);

    Iterable<User> findAll();

    String delete(Long id);

    String permanentDelete(Long id);

    User findByEmail(String email);

    Iterable<User> findByName(String name);
}
