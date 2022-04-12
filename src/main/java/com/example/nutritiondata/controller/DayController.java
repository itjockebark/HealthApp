package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.Day;
import com.example.nutritiondata.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DayController {

    @Autowired
    DayService dayService;

    @PostMapping("/habit_tracker/save_day")
    public String saveDay(Day day) {
        dayService.save(day);
        return "redirect:/habit_tracker";
    }
}
