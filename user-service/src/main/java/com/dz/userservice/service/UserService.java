package com.dz.userservice.service;

import com.dz.userservice.model.User;

import java.util.Optional;

/**
 * This interface is contain abstract method to User </br></br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
public interface UserService {

    /**
     * This method is use to save details of User
     * @param user : {@link User}
     * @return @{@link User}
     */
    User save(User user);

    /**
     * this is use to update User details
     * @param user : @{@link User}
     * @return @{@link User}
     */
    User update(User user);

    /**
     * This is use get User details by id
     * @param id : @{@link Long}
     * @return @{@link User}
     */
    Optional<User> findById(Long id);

    /**
     * Get All details of User
     * @return List of @{@link User}
     */
    Iterable<User> findAll();

    /**
     * Delete User details by id
     * @param id : long
     * @return @{@link String}
     */
    String delete(Long id);

    /**
     * Permanently Delete User details by id
     * @param id : long
     * @return @{@link String}
     */
    String permanentDelete(Long id);

    /**
     * This is use get User details by email
     * @param email : @{@link String}
     * @return @{@link User}
     */
    User findByEmail(String email);

    /**
     * This is use get User details by name
     * @param name : @{@link String}
     * @return @{@link User}
     */
    Iterable<User> findByName(String name);
}
