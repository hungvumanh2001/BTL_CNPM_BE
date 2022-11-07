package com.example.cnpm.controller;

import com.example.cnpm.model.Product;
import com.example.cnpm.model.Role;
import com.example.cnpm.model.User;
import com.example.cnpm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
public class UserController {


    @Autowired
    private UserService userService;

    //lấy tất cả các tài khoản ra
    @GetMapping("/all")
    public ResponseEntity<Iterable<User>> showAllUser() {
        Iterable<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/id")
    public ResponseEntity<Optional<User>>findById(@RequestParam int id)
    {
        Optional<User> user=userService.findById(id);
        if(user.isPresent())
            return new ResponseEntity<>(user,HttpStatus.OK);
        throw new NullPointerException("not found id user ");
    }
    @GetMapping("/search-by-username")
    public ResponseEntity<Iterable<User>>findAllByUserConaining(@RequestParam String name)
    {
        Iterable<User> user=userService.findAllByUserNameContain(name);
        if(user==null)
            return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}
