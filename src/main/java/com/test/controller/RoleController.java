package com.kal.opc.controller;

import com.kal.opc.dto.RoleDto;
import com.kal.opc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/api/v1/adminrole")
    public @ResponseBody
    List<RoleDto> adminRole(String staff_email) throws Exception {
        return roleService.adminRole(staff_email);
    }

//    @PatchMapping("/api/v1/updaterole")
//    public @ResponseBody
//    int updateRole(String staff_email, String staff_kor_name, String staff_eng_name, String department_id, String default_role_name, String database, String role_name) throws Exception {
//        if (database.equals("oc.user_information_t")) {
//            return roleService.updateRole(staff_email, staff_kor_name, staff_eng_name, department_id, default_role_name, database);
//        } else if (database.equals("oc.user_role_t")) {
//            roleService.Delete_role(role_name, staff_email, database);
//            return roleService.Insert_role(role_name, staff_email, database);
//        } else {
//            roleService.Create_user_info(staff_kor_name, staff_eng_name);
//            return roleService.Create_user_role(staff_kor_name, staff_eng_name);
//        }
//    }
}