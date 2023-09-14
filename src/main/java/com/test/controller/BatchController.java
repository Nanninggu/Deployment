package com.test.controller;

import com.test.dto.BatchDto;
import com.test.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BatchController {

    @Autowired
    BatchService batchService;

    @GetMapping("/get_values")
    public List<BatchDto> getValueForInsert() throws Exception {

        return batchService.getValues();
    }
}
