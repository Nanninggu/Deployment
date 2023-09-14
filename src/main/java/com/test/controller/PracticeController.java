package com.test.controller;

import com.test.dto.BatchDto;
import com.test.service.PracticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PracticeController {

    @Autowired
    PracticeService practiceService;

    @GetMapping("/test_values")
    public List<BatchDto> getValueForInsert() throws Exception {

        return practiceService.test_values();
    }
}
