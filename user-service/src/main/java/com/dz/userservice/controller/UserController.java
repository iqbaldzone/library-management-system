package com.dz.userservice.controller;

import com.dz.userservice.model.User;
import com.dz.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * This is controller that is responsible for operation related to user </br></br>
 *
 * Created by : Iqbal Mohmmed </br>
 *
 * Software Developer
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * This method is use to save details of User
     * @param user : {@link User}
     * @return @{@link User}
     */
    @PostMapping
    public User save(@RequestBody User user) {
        return this.userService.save(user);
    }

    /**
     * this is use to update User details
     * @param user : @{@link User}
     * @return @{@link User}
     */
    @PutMapping
    public User update(@RequestBody User user) {
        return this.userService.update(user);
    }

    /**
     * This is use get User details by id
     * @param id : @{@link Long}
     * @return @{@link User}
     */
    @GetMapping(value = "/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return this.userService.findById(id);
    }

    /**
     * Get All details of User
     * @return List of @{@link User}
     */
    @GetMapping
    public Iterable<User> getAll() {
        return this.userService.findAll();
    }

    /**
     * Delete User details by id
     * @param id : long
     * @return @{@link String}
     */
    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
        return this.userService.delete(id);
    }

    /**
     * Permanently Delete User details by id
     * @param id : long
     * @return @{@link String}
     */
    @DeleteMapping(value = "/delete/{id}")
    public String permanentDelete(@PathVariable Long id) {
        return this.userService.permanentDelete(id);
    }

    /**
     * This is use get User details by email
     * @param email : @{@link String}
     * @return @{@link User}
     */
    @GetMapping(value = "/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    /**
     * This is use get User details by name
     * @param name : @{@link String}
     * @return @{@link User}
     */
    @GetMapping(value = "/name/{name}")
    public Iterable<User> findAllByName(@PathVariable String name) {
        return userService.findByName(name);
    }
}
