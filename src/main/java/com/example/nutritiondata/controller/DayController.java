package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.Day;
import com.example.nutritiondata.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DayController {

    @Autowired
    DayService dayService;

    @GetMapping("/manage_day")
    public String manageDay(Model model) {
        List<Day> days = dayService.findAll();
        model.addAttribute("days", days);
        return "manage_day";
    }

    @GetMapping("/manage_day/day_registration")
    public String day_registration(Model model) {
        model.addAttribute(new Day());
        return "day_registration";
    }

    @PostMapping("/manage_day/save_day")
    public String saveDay_dayRegistration(Day day) {
        dayService.save(day);
        return "redirect:/manage_day";
    }

    @PostMapping("/habit_tracker/save_day")
    public String saveDay_habitRegistration(Day day) {
        dayService.save(day);
        return "redirect:/habit_tracker";
    }
}
