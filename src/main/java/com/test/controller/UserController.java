package com.kal.opc.controller;

import com.kal.opc.dto.UserDto;
import com.kal.opc.service.UserService;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Description("102_Admin>User_Management, 102_Admin>User_Management.sql")
    /**
     * 작성자 : seungkim@hist.co.kr
     * Api 기능 : 102_Admin>User_Management 문서 기반하여 작성, 하나의 검색 화면에서 3가지의 조건을 부여
     * 조건 첫번째 : Search에 입력값이 5~6자리 영어 대문자인 경우
     * 조건 두번째 : Search에 입력값이 @를 포함하는 경우
     * 조건 세번째 : Search에 입력값이 있고 위 2가지 케이스가 아닌 경우
     */
    @GetMapping("/api/v1/adminuser")
    public @ResponseBody
    List<UserDto> getUsers(String department_id, String staff_email, String staff_kor_name, String staff_eng_name) throws Exception {
        String str1 = department_id;
        if (str1.equals(str1.toUpperCase()) && str1.length() > 6) {
            return userService.Chceck_department_id(department_id);
        } else if (staff_email.contains("@")) {
            return userService.Check_staff_email(staff_email);
        } else {
            return userService.Check_others(staff_kor_name, staff_eng_name);
        }
    }
}
