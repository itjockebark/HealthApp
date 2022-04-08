package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.Day;
import com.example.nutritiondata.model.Meal;
import com.example.nutritiondata.service.DayService;
import com.example.nutritiondata.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class DailyIntakeController {

    @Autowired
    MealService mealService;

    @Autowired
    DayService dayService;


   @GetMapping("/daily_intake")
    public String dailyIntake(Model model) {
       List<Meal> meals = mealService.findAll();
       List<Day> days = dayService.findAll();

       model.addAttribute("days", days);
       model.addAttribute("meals", meals);
       return "daily_intake";
   }

   @GetMapping("/daily_intake/total_intake/{id}")
    public String totalIntake(@PathVariable("id") Integer id, Model model) {
       Day day = dayService.findById(id);
       Integer totalCalories = mealService.totalCalories(id);
       Integer totalProtein = mealService.totalProtein(id);
       Integer totalFat = mealService.totalFat(id);
       Integer totalCarbohydrates = mealService.totalCarbohydrates(id);

       model.addAttribute("day", day);
       model.addAttribute("totalcalories", totalCalories);
       model.addAttribute("totalprotein", totalProtein);
       model.addAttribute("totalfat", totalFat);
       model.addAttribute("totalcarbohydrates", totalCarbohydrates);
       return "total_intake";
   }

    @GetMapping("/daily_intake/meal_registration")
    public String mealRegistration(Model model) {
        List<Day> days = dayService.findAll();

        model.addAttribute("days", days);
        model.addAttribute("meal", new Meal());
        model.addAttribute("pagetitle","Meal Registration");
        return "meal_registration";
    }

    @PostMapping("/daily_intake/savemeal")
    public String saveMeal(Meal meal) {
        mealService.save(meal);
        return "redirect:/daily_intake";
    }

    @GetMapping("/daily_intake/deletemeal/{id}")
    public String deleteMeal(@PathVariable("id") Integer id) {
        mealService.deleteById(id);
        return "redirect:/daily_intake";
    }

    @GetMapping("/daily_intake/editmeal/{id}")
    public String editMeal(@PathVariable("id") Integer id, Model model) {
        List<Day> days = dayService.findAll();
        Meal meal = mealService.findById(id);

        model.addAttribute("days", days);
        model.addAttribute("meal",meal);
        model.addAttribute("pagetitle","Edit Meal");
        return "meal_registration";
    }



}
