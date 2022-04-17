package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.DateClass;
import com.example.nutritiondata.model.Habit;
import com.example.nutritiondata.model.Meal;
import com.example.nutritiondata.service.DateService;
import com.example.nutritiondata.service.HabitService;
import com.example.nutritiondata.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ManagementController {

    @Autowired
    MealService mealService;

    @Autowired
    DateService dateService;

    @Autowired
    HabitService habitService;

    @GetMapping("/management")
    public String management() {
        return "management";
    }

    @GetMapping("/management/meals")
    public String meals(Model model) {
        List<Meal> meals = mealService.findAll();
        model.addAttribute("meals", meals);
        return "meals";
    }

    @GetMapping("/management/meals/delete_meal/{id}")
    public String deleteMeal(@PathVariable("id") Integer id) {
        mealService.deleteById(id);
        return "redirect:/management/meals";
    }

    @GetMapping("/management/meals/meal_registration")
    public String mealRegistration(Model model) {
        List<DateClass> dates = dateService.findAll();

        model.addAttribute("dates", dates);
        model.addAttribute("meal", new Meal());
        model.addAttribute("pagetitle","Meal Registration");
        return "meal_registration";
    }

    @PostMapping("/management/meals/save_meal")
    public String saveMeal(Meal meal) {
        mealService.save(meal);
        return "redirect:/management/meals";
    }

    @GetMapping("/management/habits")
    public String showAllHabits(Model model) {
        List<Habit> habits = habitService.findAll();
        model.addAttribute("habits", habits);
        return "habits";
    }

    @GetMapping("/management/delete_habit/{id}")
    public String deleteHabit(@PathVariable("id") Integer id) {
        habitService.deleteById(id);
        return "redirect:/management/habits";
    }

}
