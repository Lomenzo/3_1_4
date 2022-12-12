package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.repository.CrudRepository;
import ru.kata.spring.boot_security.demo.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role, Long> {
}
