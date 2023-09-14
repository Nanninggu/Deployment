package com.test.dto;

public class UserDto {

    private String staff_email;
    private String staff_kor_name;
    private String staff_eng_name;
    private String department_id;
    private String default_role_name;

    public String getStaff_email() {

        return staff_email;
    }

    public void setStaff_email() {

        this.staff_email = staff_email;
    }

    public String getStaff_kor_name() {

        return staff_kor_name;
    }

    public void setStaff_kor_name() {

        this.staff_kor_name = staff_kor_name;
    }

    public String getStaff_eng_name() {

        return staff_eng_name;
    }

    public void setStaff_eng_name() {

        this.staff_eng_name = staff_eng_name;
    }

    public String getDepartment_id() {

        return department_id;
    }

    public void setDepartment_id() {

        this.department_id = department_id;
    }

    public String getDefault_role_name() {

        return department_id;
    }

    public void setDefault_role_name() {

        this.default_role_name = default_role_name;
    }

}
