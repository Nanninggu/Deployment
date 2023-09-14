package com.test.mapper;

import com.test.dto.RoleDto;
import com.test.dto.TestDto;
import com.test.dto.UserDto;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestMapper {

    List<UserDto> getAll() throws Exception;

    List<UserDto> user_info() throws Exception;

    List<RoleDto> role_info() throws Exception;

    RoleDto role_detail(String staff_email) throws Exception;

    UserDto getusers(String department_id, String staff_email, String staff_kor_name, String staff_eng_name) throws Exception;

    List<UserDto> check_value(String department_id) throws Exception;

    List<UserDto> Check_staff_email(String staff_email) throws Exception;

    List<UserDto> Check_others(String staff_kor_name, String staff_eng_name) throws Exception;

    int create_user(String staff_email, String staff_kor_name, String staff_eng_name, String department_id, String default_role_name) throws Exception;

    void addTest(@Param("param") TestDto.AddTestParam param);

}
