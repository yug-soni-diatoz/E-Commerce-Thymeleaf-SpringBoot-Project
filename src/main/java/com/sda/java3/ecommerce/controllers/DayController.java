package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.services.DayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.inject.Named;
import javax.inject.Provider;

@RestController
public class DayController {

    private final DayService dayService;

    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping("/day/{dayNumber}")
    public String getDayName(@PathVariable int dayNumber) {
        return dayService.getDayName(dayNumber);
    }
}
