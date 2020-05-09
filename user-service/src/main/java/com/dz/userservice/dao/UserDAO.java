package com.dz.userservice.dao;

import com.dz.userservice.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDAO extends CrudRepository<User, Long> {

    @Query(value = "from User u where u.email = :email")
    User findByEmail(String email);

    @Query(value = "from User u where u.firstName like %:name% OR u.lastName like %:name%")
    Iterable<User> findByName(String name);
}
