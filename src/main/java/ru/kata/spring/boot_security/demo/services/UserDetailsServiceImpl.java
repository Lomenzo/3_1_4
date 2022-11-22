package ru.kata.spring.boot_security.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;
//import org.springframework.security.core.userdetails.User;
import ru.kata.spring.boot_security.demo.model.Role;
//import ru.kata.spring.boot_security.demo.security.UserDetailsImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Autowired
    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Optional<User> user = userDao.findByUsername(s);
        //List t = userDao.findAll();
        //User o = userDao.getOne((long)0);
        //Object user = t.get(0);
        //User u1 = user;
        User user = userDao.findByName(s);
        //if (user.isEmpty()) throw new UsernameNotFoundException("User with this name does not exist");
        if (user == null) throw new UsernameNotFoundException("User with this name does not exist");
            //if (o.getName() == null || o.getPassword() == null) throw new UsernameNotFoundException("User with this name does not exist");

        //return new UserDetailsImpl(user.get());
        //return new UserDetailsImpl(o);


//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Role role : user.getRoles()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }

//        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), grantedAuthorities);

        System.out.println(user);
        return user;
    }
}
