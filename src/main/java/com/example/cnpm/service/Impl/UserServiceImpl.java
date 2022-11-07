package com.example.cnpm.service.Impl;
import com.example.cnpm.model.User;
import com.example.cnpm.repository.UserRepository;
import com.example.cnpm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;



    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Iterable<User> findAllByUserNameContain(String username) {
        return userRepository.findAllByUsernameContaining(username);
    }


    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }


}
