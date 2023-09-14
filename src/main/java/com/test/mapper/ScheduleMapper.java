package com.test.mapper;

import com.test.dto.ScheduleDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleMapper {
    List<ScheduleDto> getScheduleValue() throws Exception;

    int insertValue () throws Exception;
}
