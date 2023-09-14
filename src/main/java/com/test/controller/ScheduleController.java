package com.test.controller;

import com.test.dto.ScheduleDto;
import com.test.mapper.ScheduleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class ScheduleController {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Scheduled(cron = "* * * * * *", zone = "Asia/Seoul")
    @PostMapping("/insert")
    public void scheduledInsert() throws Exception {
        scheduleMapper.insertValue();
        log.info("배치 입니다.");
    }

    @GetMapping("/select")
    public List<ScheduleDto> getData() throws Exception {
        return scheduleMapper.getScheduleValue();
    }
}
