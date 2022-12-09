package ru.kata.spring.boot_security.demo.services;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    // Save operation
    User saveUser(User user);

    // Read operation
    List<User> getUserList();

    // Update operation
    User updateUser(User user, Long userId);

    void save(User user);

    Optional<User> findById(Long userId);

    // Delete operation
    void deleteUserById(Long userId);

}