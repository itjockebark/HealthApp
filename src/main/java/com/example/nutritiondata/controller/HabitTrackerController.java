package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.Day;
import com.example.nutritiondata.model.Habit;
import com.example.nutritiondata.model.Meal;
import com.example.nutritiondata.service.DayService;
import com.example.nutritiondata.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HabitTrackerController {

    @Autowired
    HabitService habitService;

    @Autowired
    DayService dayService;

    @GetMapping("/habit_tracker")
    public String habitTracker(Model model) {
        List<Habit> habits = habitService.findAll();
        List<Day> days = dayService.findAll();

        model.addAttribute("habits", habits);
        model.addAttribute("days", days);
        return "habit_tracker";
    }

    @GetMapping("/habit_tracker/habit_registration")
    public String mealRegistration(Model model) {
        List<Day> days = dayService.findAll();

        model.addAttribute("days", days);
        model.addAttribute("habit", new Habit());
        //model.addAttribute("pagetitle","Meal Registration");
        return "habit_registration";
    }

    @PostMapping("/habit_tracker/save_habit")
    public String saveHabit(Habit habit) {
        habitService.save(habit);
        return "redirect:/habit_tracker";
    }
}
