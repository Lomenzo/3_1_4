package ru.kata.spring.boot_security.demo.services;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.kata.spring.boot_security.demo.dao.RoleRepo;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}