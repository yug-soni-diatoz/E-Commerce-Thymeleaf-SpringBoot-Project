package com.sda.java3.ecommerce.services;

import org.springframework.stereotype.Service;
import javax.inject.Inject;
import javax.inject.Singleton;

@Service
public class DayTypeService {

    public String getDayType(int dayNumber) {
        switch (dayNumber) {
            case 1:
            case 7:
                return "Weekend";
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return "Weekday";
            default:
                return "Invalid day";
        }
    }
}
