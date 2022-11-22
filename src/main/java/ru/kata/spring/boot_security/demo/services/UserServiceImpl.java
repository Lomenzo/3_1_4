package ru.kata.spring.boot_security.demo.services;

import ru.kata.spring.boot_security.demo.dao.RoleRepo;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

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
        List<User> userList = userDao.findAll();
        return userList;
    }

    @Override
    public User updateUser(User user, Long userId){
        User userUpdate = userDao.findById(userId).get();
        String emptyString = "";
        String newName = user.getName();
        String newPassword = user.getPassword();

        if (!emptyString.equalsIgnoreCase(newName) && Objects.nonNull(newName)) {
            userUpdate.setName(newName);
        }

        if (!emptyString.equalsIgnoreCase(newPassword) && Objects.nonNull(newPassword)) {
            userUpdate.setPassword(newPassword);
        }

        userUpdate.setSalary(user.getSalary());

        return userDao.save(userUpdate);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByName(username);
    }

    @Override
    public void save(User user) {
        user.setPassword(user.getPassword());
        user.setRoles(new HashSet<>(roleRepo.findAll()));
        userDao.save(user);
    }

    @Override
    public void deleteUserById(Long userId) {
        userDao.deleteById(userId);
    }
}