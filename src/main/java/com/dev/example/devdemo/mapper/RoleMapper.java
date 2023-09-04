package com.dev.example.devdemo.mapper;

import com.dev.example.devdemo.dto.RoleDto;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMapper {
    List<RoleDto> adminRole(String staff_email) throws Exception;

    int updateRole(String staff_email, String staff_kor_name, String staff_eng_name, String department_id, String default_role_name, String database) throws Exception;

    int deleteRole(String staff_email, String role_name, String database) throws Exception;

    int insertrole(String staff_email, String role_name, String database) throws Exception;
}
