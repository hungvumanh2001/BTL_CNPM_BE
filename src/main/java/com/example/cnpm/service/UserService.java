package com.example.cnpm.service;



import com.example.cnpm.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    /**
     * save user
     * @param user
     */
    void save(User user);

    /**
     * lấy ra tất cả tk trên hẹ thống
     * @return
     */
    Iterable<User> findAll();

    /**
     * tìm tất cả account có username chứ chuỗi đưa vào
     * @param username
     * @return
     */
    Iterable<User>findAllByUserNameContain(String username);

    /**
     *
     * @param id
     * @return Optional<User>
     */
    Optional<User> findById(Long id);


    /**
     *
     * @param user
     * @return true or false
     */
    boolean checkLogin(User user);

    /**
     *
     * @param user
     * @return true or false
     */

    boolean isCorrectConfirmPassword(User user);

    User findByUsername(String user);

    void delete(Long id);
}