package com.example.cnpm.service;

import com.example.cnpm.model.User;

import java.util.Optional;

public interface UserService{
    /**
     * find all user contains input username
     * @param username
     * @return
     */
    Iterable<User>findAllByUserNameContain(String username);

    /**
     * find user by id
     * @param id
     * @return
     */
    Optional<User> findById(Integer id);
}