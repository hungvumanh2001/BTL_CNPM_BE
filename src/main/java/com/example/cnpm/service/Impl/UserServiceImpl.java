package com.example.cnpm.service.Impl;

import com.example.cnpm.model.User;
import com.example.cnpm.repository.UserRepository;
import com.example.cnpm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public Iterable<User> findAllByUserNameContain(String username) {
        return repository.findAllByUsernameContaining(username);
    }

    @Override
    public Optional<User> findById(Integer id) {
        return repository.findById(id);
    }
}
