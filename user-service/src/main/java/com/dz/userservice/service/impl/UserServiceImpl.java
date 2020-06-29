package com.dz.userservice.service.impl;

import com.dz.userservice.dao.UserDAO;
import com.dz.userservice.model.User;
import com.dz.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Objects;
import java.util.Optional;

/**
 * This service is impl method of User operation </br></br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    /**
     * This method is use to save details of User
     * @param user : {@link User}
     * @return @{@link User}
     */
    @Override
    public User save(User user) {
        if (Objects.nonNull(this.findByEmail(user.getEmail()))) {
            throw new RuntimeException(String.format("%s email is already exist", user.getEmail()));
        }
        user.setCreatedDate(new Date(System.currentTimeMillis()));
        return userDAO.save(user);
    }

    /**
     * this is use to update User details
     * @param user : @{@link User}
     * @return @{@link User}
     */
    @Override
    public User update(User user) {
        user.setUpdatedDate(new Date(System.currentTimeMillis()));
        return userDAO.save(user);
    }

    /**
     * This is use get User details by id
     * @param id : @{@link Long}
     * @return @{@link User}
     */
    @Override
    public Optional<User> findById(Long id) {
        return userDAO.findById(id);
    }

    /**
     * Get All details of User
     * @return List of @{@link User}
     */
    @Override
    public Iterable<User> findAll() {
        return userDAO.findAll();
    }

    /**
     * Delete User details by id
     * @param id : long
     * @return @{@link String}
     */
    @Override
    public String delete(Long id) {
        User user = this.findById(id).get();
        user.setDeleted(true);
        user.setDeletedDate(new Date(System.currentTimeMillis()));
        userDAO.save(user);
        return "deleted";
    }

    /**
     * Permanently Delete User details by id
     * @param id : long
     * @return @{@link String}
     */
    @Override
    public String permanentDelete(Long id) {
        userDAO.deleteById(id);
        return "deleted";
    }

    /**
     * This is use get User details by email
     * @param email : @{@link String}
     * @return @{@link User}
     */
    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }

    /**
     * This is use get User details by name
     * @param name : @{@link String}
     * @return @{@link User}
     */
    @Override
    public Iterable<User> findByName(String name) {
        return userDAO.findByName(name);
    }
}
