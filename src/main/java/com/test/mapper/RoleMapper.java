package com.test.mapper;

import com.test.dto.RoleDto;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RoleMapper {
    List<RoleDto> adminRole(String staff_email) throws Exception;

}
