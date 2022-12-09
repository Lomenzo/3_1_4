//package ru.kata.spring.boot_security.demo.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import ru.kata.spring.boot_security.demo.model.User;
//import ru.kata.spring.boot_security.demo.services.UserService;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1/user")    //    http://localhost:8080/api/v1/user/1
//public class UserResource {
//
//    private final UserService userService;
//
//    @Autowired
//    public UserResource (UserService userService){
//        this.userService = userService;
//    }
//
//    @GetMapping("/{userId}")
//    public User findById(@PathVariable long userId) {
//        System.out.println("lalala");
//        return userService.findById(userId).get();
//    }
//
//
//    @PostMapping
//    public User create(@RequestBody User user) {
//        System.out.println("lala");
//        return userService.saveUser(user);
//    }
//
//}
