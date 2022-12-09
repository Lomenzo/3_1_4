package ru.kata.spring.boot_security.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/user")
    public ModelAndView showUserData() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping(value = "/admin/userApp")
    public String showUserForm(Model model, ModelMap modelMap, Model modelRole) {
        model.addAttribute("userFormer", new User());
        List<User> userList = userService.getUserList();
        modelMap.addAttribute("users", userList);
        modelRole.addAttribute("roleFormer", new Role());
        return "adminPage";
    }

    @PostMapping(value = "/admin/userApp")
    public String addUserPostMethod(Model model, @ModelAttribute("userFormer") User userForm, Model modelRole, ModelMap modelMap) {
        model.addAttribute("userFormer", userForm);
        //modelRole.addAttribute("roleFormer", roleForm);


//        List<String> options = new ArrayList<String>();
//        options.add("option 1");
//        options.add("option 2");
//        modelRole.addAttribute("options", options);
//        System.out.println(modelRole.toString().concat(" - roleForm give THAT"));

        String name = userForm.getName();
        String password = userForm.getPassword();
        int salary = userForm.getSalary();
        User newUser = new User(name,password,salary);
        userService.saveUser(newUser);
        List<User> userList = userService.getUserList();
        modelMap.addAttribute("users", userList);
        return "adminPage";
    }

    @GetMapping("/admin/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("userFinded", new User());
        return "updateUserPage";
    }

    @PostMapping("/admin/update/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("userFinded") User userFinded, Model model) {
        model.addAttribute("userFinded", userFinded);
        userService.updateUser(userFinded, id);
        return "updateUserPage";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        userService.deleteUserById(id);
        return "deletedUserPage";
    }

    @DeleteMapping("/{id}")
    public String findById(@PathVariable long id) {
        userService.deleteUserById(id);
        return "redirect:/user";
    }

}
