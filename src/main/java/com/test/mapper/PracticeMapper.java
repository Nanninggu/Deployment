package com.test.mapper;

import com.test.dto.BatchDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PracticeMapper {

    List<BatchDto> test_values() throws Exception;

}
