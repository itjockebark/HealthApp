package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.DateClass;
import com.example.nutritiondata.model.DayClass;
import com.example.nutritiondata.service.DateService;
import com.example.nutritiondata.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "dates";
    }

    @GetMapping("/manage_date/date_registration")
    public String dateRegistration(Model model) {
        List<DayClass> days = dayService.findAll();
        model.addAttribute("days", days);
        model.addAttribute("date", new DateClass());
        return "date_registration";
    }

    @GetMapping("/manage_date/delete_date/{id}")
    public String deleteDate(@PathVariable("id") Integer id) {
        dateService.deleteById(id);
        return "redirect:/manage_date";
    }

    @PostMapping("/manage_date/save_date")
    public String saveDate_dateRegistration(DateClass date) {
        dateService.save(date);
        return "redirect:/manage_date";
    }

    @PostMapping("/habit_tracker/save_date")
    public String saveDate_habitRegistration(DateClass date) {
        dayService.save(date.getDay());
        dateService.save(date);
        return "redirect:/habit_tracker";
    }

    @PostMapping("/daily_intake/save_date")
    public String saveDate_mealRegistration(DateClass date) {
        dayService.save(date.getDay());
        dateService.save(date);
        return "redirect:/daily_intake";
    }

    @GetMapping("manage_date/edit_date/{id}")
    public String manageDate(@PathVariable("id") Integer id, Model model) {
        DateClass date = dateService.findById(id);
        List<DayClass> days = dayService.findAll();
        model.addAttribute("days", days);
        model.addAttribute("date",date);
        return "date_registration";
    }
}
