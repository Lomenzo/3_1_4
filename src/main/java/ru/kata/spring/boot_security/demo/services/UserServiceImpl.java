package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User saveUser (User user) {
        User userSave = userDao.save(user);
        return userSave;
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = userDao.findAll();
        return userList;
    }

    @Override
    public User updateUser(User user, Long userId){
        User userUpdate = userDao.findById(userId).get();
        String emptyString = "";
        String newName = user.getName();
        String newLastName = user.getLastName();

        if (!emptyString.equalsIgnoreCase(newName) && Objects.nonNull(newName)) {
            userUpdate.setName(newName);
        }

        if (!emptyString.equalsIgnoreCase(newLastName) && Objects.nonNull(newLastName)) {
            userUpdate.setLastName(newLastName);
        }

        userUpdate.setSalary(user.getSalary());

        return userDao.save(userUpdate);
    }

    @Override
    public void deleteUserById(Long userId) {
        userDao.deleteById(userId);
    }
}