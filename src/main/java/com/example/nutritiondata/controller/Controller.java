package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.Day;
import com.example.nutritiondata.model.Meal;
import com.example.nutritiondata.service.DayService;
import com.example.nutritiondata.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    MealService mealService;

    @Autowired
    DayService dayService;


    @GetMapping("/daily_intake")
    public String dailyIntake(Model model) {
        List<Meal> meals = mealService.getAllMeals();
        List<Day> days = dayService.getAllDays();
        model.addAttribute("days", days);
        model.addAttribute("meals", meals);
        return "daily_intake";
    }

    @GetMapping("/daily_intake/meal_registration")
    public String mealRegistration(Model model) {
        List<Day> days = dayService.getAllDays();
        model.addAttribute("days", days);
        model.addAttribute("meal", new Meal());
        return "meal_registration";
    }

    @PostMapping("/daily_intake/savemeal")
    public String saveMeal(Meal meal) {
        mealService.save(meal);
        return "redirect:/daily_intake";
    }

}
