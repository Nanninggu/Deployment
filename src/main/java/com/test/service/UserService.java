package com.test.service;

import com.test.dto.UserDto;
import com.test.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    TestMapper testMapper;

    public UserDto getusers(String department_id, String staff_email, String staff_kor_name, String staff_eng_name) throws Exception {

        return testMapper.getusers(department_id, staff_email, staff_kor_name, staff_eng_name);
    }

    public List<UserDto> Chceck_department_id(String department_id) throws Exception {
        return testMapper.check_value(department_id);
    }

    public List<UserDto> Check_staff_email(String staff_email) throws Exception {
        return testMapper.Check_staff_email(staff_email);
    }

    public List<UserDto> Check_others(String staff_kor_name, String staff_eng_name) throws Exception {
        return testMapper.Check_others(staff_kor_name, staff_eng_name);
    }

}