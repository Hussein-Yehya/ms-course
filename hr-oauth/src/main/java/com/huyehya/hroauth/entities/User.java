package com.huyehya.hroauth.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class User {

    private Long id;
    private String name;

    private String email;
    private String password;

    private Set<Role> roles = new HashSet<>();

}
