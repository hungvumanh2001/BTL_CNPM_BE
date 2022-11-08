package com.example.cnpm.service.Impl;


import com.example.cnpm.model.Role;
import com.example.cnpm.repository.RoleRepository;
import com.example.cnpm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;



    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }




}
