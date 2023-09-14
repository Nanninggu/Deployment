package com.test;

import com.test.middle.Middle;
import com.test.util.ForStatement;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@EnableScheduling
@EnableBatchProcessing // 배치 기능 활성화
public class DevDemoApplication {

    @Autowired
    public static ForStatement forStatement;
    @Autowired
    public static Middle middle;

    public static void main(String[] args) {

        SpringApplication.run(DevDemoApplication.class, args);

        forStatement.repeat();

        forStatement.return_test();

        /** 변수를 return으로 받기 */
        LocalDate now = forStatement.return_date(); // return 으로 받은 값을 변수에 담는다.
        System.out.println(now);

        /** 단순 문자열 리턴 받기 */
        String string = forStatement.return_string();
        System.out.println(string);

        /** 현재 일시 구하기 */
        LocalDateTime localDateTime = forStatement.localDateTime();
        System.out.println(localDateTime);

        /** 미들에서 출력하기 */
        LocalDate localDate = middle.localDate();
        System.out.println("LocalDate" + ": " + localDate);
    }
}