package com.test.service;

import com.test.dto.RoleDto;
import com.test.mapper.KmsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KmsService {

    @Autowired
    KmsMapper kmsMapper;

    public RoleDto adminRoleKms(String staff_email) throws Exception {

        return kmsMapper.adminRoleKms(staff_email);
    }

    public int encrypt_insert_email(String result_encrypt, String name) throws Exception {

        return kmsMapper.encrypt_email(result_encrypt, name);
    }

    public String get_encrypt_value (String name) throws Exception {
        return kmsMapper.get_encrypt_value(name);
    }
}
