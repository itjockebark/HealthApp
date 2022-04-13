package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.DateClass;
import com.example.nutritiondata.model.DayClass;
import com.example.nutritiondata.service.DateService;
import com.example.nutritiondata.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DateController {

    @Autowired
    DateService dateService;

    @Autowired
    DayService dayService;

    @GetMapping("/manage_date")
    public String manageDate(Model model) {
        List<DateClass> dates = dateService.findAll();
        model.addAttribute("dates", dates);
        return "manage_date";
    }

    @GetMapping("/manage_date/date_registration")
    public String dateRegistration(Model model) {
        List<DayClass> days = dayService.findAll();
        model.addAttribute("days", days);
        model.addAttribute("date", new DateClass());
        return "date_registration";
    }

    @PostMapping("/manage_date/save_date")
    public String saveDate(DateClass date) {
        dateService.save(date);
        return "redirect:/manage_date";
    }
}
