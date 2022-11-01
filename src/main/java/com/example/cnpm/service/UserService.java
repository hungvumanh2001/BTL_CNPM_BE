package com.example.cnpm.service;

import com.example.cnpm.model.User;

public interface UserService{
    Iterable<User>findAllByUserNameContain(String username);
}