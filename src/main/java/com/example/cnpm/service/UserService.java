package com.example.cnpm.service;

import com.example.cnpm.model.User;

import java.util.Optional;



public interface UserService  {
    //thêm 1 nhân viên
    void save(User user);

    //xem tất cả tài khoản trên hệ thống
    Iterable<User> findAll();


    User findByUsername(String username);

    Iterable<User>findAllByUserNameContain(String username);


    //xem chi tiết nhân viên
    Optional<User> findById(Integer id);



}
