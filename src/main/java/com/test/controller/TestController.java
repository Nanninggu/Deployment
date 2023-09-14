package com.test.controller;

import com.test.dto.BatchDto;
import com.test.dto.UserDto;
import com.test.service.BatchService;
import com.test.service.TestService;
import com.test.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    TestService testService;

    @Autowired
    BatchService batchService;

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    @RequestMapping("/query")
    public @ResponseBody
    List<UserDto> query() throws Exception {

        return testService.getAll();
    }

    @RequestMapping("/user_info")
    public @ResponseBody
    List<UserDto> user_info() throws Exception {

        return testService.user_info();
    }

    @PostMapping("/api/test")
    public void addTest(@RequestBody TestDto.AddTestParam param) {

        testService.addTest(param);
    }

    @RequestMapping("/for_test")
    public @ResponseBody
    List<UserDto> for_test() throws Exception {

        return testService.getAll();
    }

    @RequestMapping("/for_state")
    public @ResponseBody
    List<UserDto> for_state() throws Exception {

        return testService.getAll();
    }

    @PostMapping("/create_user")
    public @ResponseBody
    int create_user(String staff_email, String staff_kor_name, String staff_eng_name, String department_id, String default_role_name) throws Exception {

        return testService.create_user(staff_email, staff_kor_name, staff_eng_name, department_id, default_role_name);
    }

    @RequestMapping("/verification")
    public @ResponseBody
    List<BatchDto> value_check() throws Exception {

        return batchService.getValues();
    }
}