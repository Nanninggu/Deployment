package com.test.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoleDto {

    private String role_name;

    private String staff_email;

    public String getRole_name() {

        return role_name;
    }

    public void setRole_name() {

        this.role_name = role_name;
    }

    public String getStaff_email() {

        return staff_email;
    }

    public void setStaff_email() {

        this.staff_email = staff_email;
    }

    private String menu_id;
    private String read_yn;
    private String department_id;
    private String write_yn;

    public String getMenu_id() {

        return menu_id;
    }

    public void setMenu_id() {

        this.menu_id = menu_id;
    }

    public String getRead_yn() {

        return read_yn;
    }

    public void setRead_yn() {

        this.read_yn = read_yn;
    }

    public String getDepartment_id() {

        return department_id;
    }

    public void setDepartment_id() {

        this.department_id = department_id;
    }

    public String getWrite_yn() {

        return write_yn;
    }

    public void setWrite_yn() {

        this.write_yn = write_yn;
    }
}
