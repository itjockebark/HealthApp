package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.DateClass;
import com.example.nutritiondata.model.Habit;
import com.example.nutritiondata.model.Meal;
import com.example.nutritiondata.service.DateService;
import com.example.nutritiondata.service.DayService;
import com.example.nutritiondata.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HabitTrackerController {

    @Autowired
    HabitService habitService;

    @Autowired
    DateService dateService;

    @Autowired
    DayService dayService;

    @GetMapping("/habit_tracker")
    public String habitTracker(Model model) {
        List<Habit> habits = habitService.findAll();
        List<DateClass> dates = dateService.findAll();

        model.addAttribute("habits", habits);
        model.addAttribute("dates", dates);
        return "habit_tracker";
    }

    @GetMapping("/habit_tracker/connected_habits/{id}")
    public String connectedHabits(@PathVariable("id") Integer id, Model model){
        DateClass date = dateService.findById(id);
        List<Habit> habits = date.getHabits();
        model.addAttribute("date", date);
        model.addAttribute("habits", habits);

        return "connected_habits";
    }


    @GetMapping("/habit_tracker/edit_habit/{id}")
    public String editHabit(@PathVariable("id") Integer id, Model model) {
        DateClass date = dateService.findById(id);
        List<Habit> habits = habitService.findAll();

        model.addAttribute("date", date);
        model.addAttribute("habits", habits);
        return "edit_habit_tracker";
    }

    @PostMapping("/habit_tracker/save_date")
    public String saveDateAndDay(DateClass date) {
        dayService.save(date.getDay());
        dateService.save(date);
        return "redirect:/habit_tracker";
    }


}
