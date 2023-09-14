package com.test.service;

import com.test.dto.BatchDto;
import com.test.mapper.PracticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PracticeService {

    @Autowired
    PracticeMapper practiceMapper;

    public List<BatchDto> test_values() throws Exception {

        return practiceMapper.test_values();
    }
}
