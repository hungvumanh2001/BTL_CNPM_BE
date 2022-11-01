package com.example.cnpm.controller;

import com.example.cnpm.model.Role;
import com.example.cnpm.model.User;
import com.example.cnpm.service.RoleService;
import com.example.cnpm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
@PropertySource("classpath:application.properties")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/search-by-username")
    public ResponseEntity<Iterable<User>> findAllByUserConaining(@RequestParam String name)
    {
        Iterable<User> user=userService.findAllByUserNameContain(name);
        if(user==null)
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<User>detailUser(@RequestParam Long id)
    {
        Optional<User> user=userService.findById(id);
        if(user.isPresent())
        {
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //update account or register
    @PostMapping("/change-account")
    public ResponseEntity<User> createUser(@RequestBody User user,@RequestParam boolean update) throws Exception {
        Iterable<User> users = userService.findAll();
        //lấy ra để so xem có cái nào trungh khôg
        for (User currentUser : users) {
            if (currentUser.getUsername().equals(user.getUsername())) {
                if(update) {
                    userService.save(user);
                    //update thành công
                    return new ResponseEntity<>(HttpStatus.OK);
                }
                else
                     throw new Exception("Username đã tồn tại");
            }
        }
        if (!userService.isCorrectConfirmPassword(user)) {

            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (user.getRoles() != null) {
            Role role = roleService.findByName("ROLE_ADMIN");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            user.setRoles(roles);
        } else {

            Role role1 = roleService.findByName("ROLE_USER");
            Set<Role> roles1 = new HashSet<>();
            roles1.add(role1);
            user.setRoles(roles1);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setConfirmPassword(passwordEncoder.encode(user.getConfirmPassword()));
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
