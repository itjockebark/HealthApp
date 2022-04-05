package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.Meal;
import com.example.nutritiondata.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MealController {

    @Autowired
    MealService service;

    @GetMapping("/daily_intake")
    public String dailyIntake(Model model) {
        return "daily_intake";
    }

    @GetMapping("/daily_intake/meal_registration")
    public String mealRegistration(Model model) {
        model.addAttribute("meal", new Meal());
        return "meal_registration";
    }

    @PostMapping("/daily_intake/savemeal")
    public String saveMeal(Meal meal) {
        service.save(meal);
        return "redirect:/daily_intake";
    }

}
