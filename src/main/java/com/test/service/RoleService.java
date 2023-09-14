package com.kal.opc.service;

import com.kal.opc.dto.RoleDto;
import com.kal.opc.mapper.RoleMapper;
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

    public int updateRole(String staff_email, String staff_kor_name, String staff_eng_name, String department_id, String default_role_name, String database) throws Exception {

        return roleMapper.updateRole(staff_email, staff_kor_name, staff_eng_name, department_id, default_role_name, database);
    }

    public int Delete_role(String staff_email, String role_name, String database) throws Exception {

        return roleMapper.deleteRole(staff_email, role_name, database);
    }

    public int Insert_role(String staff_email, String role_name, String database) throws Exception {

        return roleMapper.insertrole(staff_email, role_name, database);
    }
}
