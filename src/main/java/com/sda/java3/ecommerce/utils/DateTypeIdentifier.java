package com.sda.java3.ecommerce.utils;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTypeIdentifier {

    public void identifyDateType(Object obj) {
        if (obj instanceof Date) {
            System.out.println("This is a java.util.Date.");
        } else if (obj instanceof LocalDate) {
            System.out.println("This is a java.time.LocalDate.");
        } else if (obj instanceof LocalDateTime) {
            System.out.println("This is a java.time.LocalDateTime.");
        } else {
            System.out.println("Unknown date type.");
        }
    }

}
