package com.test.service;

import com.test.dto.RoleDto;
import com.test.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<RoleDto> adminRole(String staff_email) throws Exception {

        return roleMapper.adminRole(staff_email);
    }

    public List<RoleDto> adminRole_kms(String staff_email) throws Exception {

        return roleMapper.adminRole(staff_email);
    }
}
