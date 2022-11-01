package com.example.cnpm.controller;

import com.example.cnpm.model.User;
import com.example.cnpm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/search-by-username")
    public ResponseEntity<Iterable<User>> findAllByUserConaining(@RequestParam String name)
    {
        Iterable<User> user=userService.findAllByUserNameContain(name);
        if(user==null)
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<User>detailUser(@RequestParam Integer id)
    {
        Optional<User> user=userService.findById(id);
        if(user.isPresent())
        {
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
