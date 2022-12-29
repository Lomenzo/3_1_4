package ru.kata.spring.boot_security.demo.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Component
@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role(String name) {
        //Hardcode roles Admin+User
//        if (name.contains("ADMIN")) {
//            this.id = 2L;
//        } else if (name.contains("USER")) {
//            this.id = (long)1;
//        }

        this.name = name;
    }

//    @ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
//    private Set<User> users;


    @Override
    public String getAuthority() {
        return this.name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
