package ru.kata.spring.boot_security.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class AppRestController {

    private final UserService userService;

    @Autowired
    public AppRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping()
    public List<User> allUsers(@ModelAttribute("user") User user) {
        System.out.println("LOG: Rest getAllUsers Controller already called");
        return userService.getUserList();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable long id) {
        System.out.println("LOG: Rest getUserByID Controller already called");
        return userService.getById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        System.out.println("LOG: Rest createUser Controller already called");
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user) {
        System.out.println("LOG: Rest updateUser Controller already called");
        userService.updateUser(user);
        return user;
    }

    @DeleteMapping ("/{id}")
    public String deleteById(@PathVariable long id) {
        System.out.println("LOG: Rest deleteUserByID Controller already called");
        userService.deleteUserById(id);
        return "Ok";
    }

}