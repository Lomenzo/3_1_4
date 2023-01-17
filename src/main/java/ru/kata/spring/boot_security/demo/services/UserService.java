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
    void updateUser(User user);

    // Delete operation
    void deleteUserById(Long userId);

    void addDefaultUser();

    public User getById(long id);

}