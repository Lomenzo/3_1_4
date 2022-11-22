package ru.kata.spring.boot_security.demo.services;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    // Save operation
    User saveUser(User user);

    // Read operation
    List<User> getUserList();

    // Update operation
    User updateUser(User user, Long userId);

    void save(User user);

    // Delete operation
    void deleteUserById(Long userId);

}