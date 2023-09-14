package com.kal.opc.service;

import com.kal.opc.dto.TestDto;
import com.kal.opc.dto.UserDto;
import com.kal.opc.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestMapper testMapper;

    public List<UserDto> getAll() throws Exception {

        return testMapper.getAll();
    }

    public List<UserDto> user_info() throws Exception {

        return testMapper.user_info();
    }

    @Transactional
    public void addTest(TestDto.AddTestParam param) {

        testMapper.addTest(param);
    }

    @Transactional
    public int create_user(String staff_email, String staff_kor_name, String staff_eng_name, String department_id, String default_role_name) throws Exception {

        return testMapper.create_user(staff_email, staff_kor_name, staff_eng_name, department_id, default_role_name);
    }
}
