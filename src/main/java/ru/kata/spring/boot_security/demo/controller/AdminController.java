package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.kata.spring.boot_security.demo.model.Role;
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
    public String addUserPostMethod(/*Model model, */@ModelAttribute("userFormer") User userForm/*, ModelMap modelMap*/) {
        //model.addAttribute("userFormer", userForm);
//                    String name = userForm.getName();
//                    String password = userForm.getPassword();
//                    int salary = userForm.getSalary();
//                    User newUser = new User(name,password,salary);
        userService.saveUser(userForm);
        //List<User> userList = userService.getUserList();
        /*modelMap.addAttribute("users", userList);*/
        return "redirect:/admin";
    }

//    @GetMapping("/admin/edit/{id}")
//    public String showUpdateForm(@PathVariable("id") long id, Model model) {
//        model.addAttribute("userFinded", new User());
//        return "updateUserPage";
//    }
//
//    @PostMapping("/admin/update/{id}")
//    public String updateUser(@PathVariable("id") long id, @ModelAttribute("userFinded") User userFinded, Model model) {
//        model.addAttribute("userFinded", userFinded);
//        userService.updateUser(userFinded, id);
//        return "updateUserPage";
//    }

    @PostMapping("/update")
    public String updateUser(@ModelAttribute User editUser) {
        userService.editUser(editUser);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/admin";
    }
}
