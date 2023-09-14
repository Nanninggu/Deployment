package com.test.controller;

import com.test.dto.RoleDto;
//import com.test.service.KmsService;
import com.test.service.KmsService;
import com.test.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    KmsService kmsService;

    @GetMapping("/api/v1/adminrole")
    public @ResponseBody
    List<RoleDto> adminRole(String staff_email) throws Exception {
        return roleService.adminRole(staff_email);
    }

    @GetMapping("/api/v1/adminrole_kms")
    public @ResponseBody
    RoleDto adminRoleKms(String staff_email) throws Exception {
        return kmsService.adminRoleKms(staff_email);
    }
}