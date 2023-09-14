package com.test.middle;

import com.test.util.ForStatement;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class Middle {

    @Autowired
    static
    ForStatement forStatement;

    public static LocalDate localDate() {
        LocalDate localDate = forStatement.return_date();
        return localDate;
    }
}
