package com.sda.java3.ecommerce.controllers;

import com.sda.java3.ecommerce.services.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DayController {

    private final DayService dayService;

    @Autowired
    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @GetMapping("/day/{dayNumber}")
    public String getDayName(@PathVariable int dayNumber) {
        return dayService.getDayName(dayNumber);
    }
}
