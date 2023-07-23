package com.example.companies.application.utils;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate subtractMonthsFromToday(int cantMonths){
        return LocalDate.now().minusMonths(cantMonths);
    }

}
