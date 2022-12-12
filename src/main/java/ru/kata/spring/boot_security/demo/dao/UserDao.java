package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.repository.CrudRepository;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
    Optional<User> findByName(String name);
}