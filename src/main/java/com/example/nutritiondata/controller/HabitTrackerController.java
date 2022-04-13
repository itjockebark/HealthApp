package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.DateClass;
import com.example.nutritiondata.model.Habit;
import com.example.nutritiondata.service.DateService;
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

    @GetMapping("/habit_tracker")
    public String habitTracker(Model model) {
        List<Habit> habits = habitService.findAll();
        List<DateClass> dates = dateService.findAll();

        model.addAttribute("habits", habits);
        model.addAttribute("dates", dates);
        return "habit_tracker";
    }

    @GetMapping("/habit_tracker/habit_registration")
    public String habitRegistration(Model model) {
        List<DateClass> dates = dateService.findAll();

        model.addAttribute("dates", dates);
        model.addAttribute("habit", new Habit());
        return "habit_registration";
    }

    @PostMapping("/habit_tracker/save_habit")
    public String saveHabit(Habit habit) {
        habitService.save(habit);
        return "redirect:/habit_tracker";
    }

    @GetMapping("/habit_tracker/delete_habit")
    public String habitToDelete(Model model) {
        List<Habit> habits = habitService.findAll();
        model.addAttribute("habits", habits);
        return "delete_habit";
    }

    @GetMapping("/habit_tracker/delete_habit/delete/{id}")
    public String deleteHabit(@PathVariable("id") Integer id) {
        habitService.deleteById(id);
        return "redirect:/habit_tracker";
    }

    @GetMapping("/habit_tracker/edit_habit/{id}")
    public String editMeal(@PathVariable("id") Integer id, Model model) {
        DateClass date = dateService.findById(id);
        List<Habit> habits = habitService.findAll();

        model.addAttribute("date", date);
        model.addAttribute("habits", habits);
        return "edit_habit";
    }

}
