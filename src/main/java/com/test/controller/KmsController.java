package com.test.controller;

import com.test.service.KmsService;
import com.test.service.KmsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class KmsController {

    private final KmsServiceImpl kmsServiceEnv;
    @GetMapping("/encrypt")
    public String encrypt(@RequestParam String plainText, String name) {

        return kmsServiceEnv.encrypt(plainText, name);
    }

    @PostMapping("/encrypt_insert_email")
    public String encrypt_insert_email(@RequestParam String staff_email, String name) {

        return kmsServiceEnv.encrypt(staff_email, name);
    }

    @GetMapping("/decrypt_select_email")
    public String decrypt(@RequestParam String name) {

        return kmsServiceEnv.decrypt(name);
    }

}
