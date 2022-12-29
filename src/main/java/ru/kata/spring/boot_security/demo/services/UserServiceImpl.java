package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.boot_security.demo.dao.RoleRepo;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Autowired
    RoleRepo roleRepo;


    @Override
    public User saveUser (User user) {
        User userSave = userDao.save(user);
        return userSave;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = (List<User>) userDao.findAll();
        return userList;
    }

    @Override
    public void updateUser (User user){
            userDao.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        userDao.deleteById(userId);
    }

    @Override
    @PostConstruct
    public void addDefaultUser() {
        Set<Role> roles1 = new HashSet<>();
        roles1.add(roleRepo.save(new Role("USER")));
        Set<Role> roles2 = new HashSet<>();
        roles2.add(roleRepo.save(new Role("ADMIN")));
        User user1 = new User("vas", "123", 1, roles1);
        User user2 = new User("vzv", "qwe", 77, roles2);
        saveUser(user1);
        saveUser(user2);
    }
}