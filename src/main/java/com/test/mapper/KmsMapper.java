package com.test.mapper;

import com.test.dto.RoleDto;
import org.springframework.stereotype.Repository;

@Repository
public interface KmsMapper {
    RoleDto adminRoleKms(String staff_email) throws Exception;

    int encrypt_email(String result_encrypt, String name) throws Exception;

    String get_encrypt_value (String name) throws Exception;
}
