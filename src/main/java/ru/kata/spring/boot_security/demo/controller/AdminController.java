package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;


    @GetMapping(value = "/admin")
    public String showUserForm(Model model) {
        model.addAttribute("userFormer", new User());
        List<User> userList = userService.getUserList();
        model.addAttribute("users", userList);
        model.addAttribute("roleNames", roleService.getAllRoles());
        return "adminPage";
    }

    @PostMapping(value = "/create")
    public String addUserPostMethod(@ModelAttribute("userFormer") User userForm) {
        userService.saveUser(userForm);
        return "redirect:/admin";
    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User editUser) {
        userService.updateUser(editUser);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}
