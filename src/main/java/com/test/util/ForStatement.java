package com.test.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;

public class ForStatement {

    /**
     * 3회 root를 도는 반복문
     */
    public static void repeat() {
        for (int i = 0; i < 3; i++) {
            System.out.println(i + "번째 처리");
        }
    }

    /**
     * 현재날짜 구하기
     */
    public static void return_test() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
    }

    /**
     * 연월일 구하기
     */
    public static LocalDate return_date() {
        LocalDate now = LocalDate.now();
        LocalDate parisNow = LocalDate.now(ZoneId.of("Europe/Paris"));
        return now;
    }

    /**
     * 간단한 문자열 리턴하기
     */
    public static String return_string() {
        String name = "승현";
        String firstname = "김";
        return firstname + name;
    }

    /**
     * 현재 일시 구하기
     */
    public static LocalDateTime localDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime;
    }
}

