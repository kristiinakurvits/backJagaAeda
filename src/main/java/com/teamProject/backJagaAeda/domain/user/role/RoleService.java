package com.teamProject.backJagaAeda.domain.user.role;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;


    public Role getRoleUser() {
        return roleRepository.findById(2).get();
    }
}
