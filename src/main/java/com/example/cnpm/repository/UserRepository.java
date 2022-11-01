package com.example.cnpm.repository;

import com.example.cnpm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Iterable<User>findAllByUsernameContaining(String name);


}