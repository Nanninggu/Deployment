package com.test.service;

import com.test.dto.BatchDto;
import com.test.mapper.BatchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchService {

    @Autowired
    BatchMapper batchMapper;

    public List<BatchDto> getValues() throws Exception {
        return batchMapper.getValues();
    }
}
