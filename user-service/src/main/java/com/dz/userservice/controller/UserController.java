package com.dz.userservice.controller;

import com.dz.userservice.model.User;
import com.dz.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User save(@RequestBody User user) {
        return this.userService.save(user);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return this.userService.update(user);
    }

    @GetMapping(value = "/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return this.userService.findById(id);
    }

    @GetMapping
    public Iterable<User> getAll() {
        return this.userService.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable Long id) {
        return this.userService.delete(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public String permanentDelete(@PathVariable Long id) {
        return this.userService.permanentDelete(id);
    }

    @GetMapping(value = "/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }

    @GetMapping(value = "/name/{name}")
    public Iterable<User> findAllByName(@PathVariable String name) {
        return userService.findByName(name);
    }
}
