package com.example.cnpm.service;



import com.example.cnpm.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {

    Role findByName(String name);

}
