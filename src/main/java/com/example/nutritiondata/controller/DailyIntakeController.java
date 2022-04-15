package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.DateClass;
import com.example.nutritiondata.model.Meal;
import com.example.nutritiondata.service.DateService;
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
    DateService dateService;


   @GetMapping("/daily_intake")
    public String dailyIntake(Model model) {
       List<Meal> meals = mealService.findAll();
       List<DateClass> dates = dateService.findAll();

       model.addAttribute("dates", dates);
       model.addAttribute("meals", meals);
       return "daily_intake";
   }

    @GetMapping("/daily_intake/connected_meals/{id}")
    public String connectedMeals(@PathVariable("id") Integer id, Model model){
        DateClass date = dateService.findById(id);
        List<Meal> meals = date.getMeals();
        model.addAttribute("date", date);
        model.addAttribute("meals", meals);

        Integer totalCalories = mealService.totalCalories(id);
        Integer totalProtein = mealService.totalProtein(id);
        model.addAttribute("totalcalories", totalCalories);
        model.addAttribute("totalprotein", totalProtein);
        return "connected_meals";
    }

    @GetMapping("/daily_intake/meals")
    public String showAllMeals(Model model) {
        List<Meal> meals = mealService.findAll();
        model.addAttribute("meals", meals);
        return "meals";
    }

   @GetMapping("/daily_intake/meal_registration")
    public String mealRegistration(Model model) {
       List<DateClass> dates = dateService.findAll();

        model.addAttribute("dates", dates);
        model.addAttribute("meal", new Meal());
        model.addAttribute("pagetitle","Meal Registration");
        return "meal_registration";
    }

    @PostMapping("/daily_intake/save_meal")
    public String saveMeal(Meal meal) {
        mealService.save(meal);
        return "redirect:/daily_intake";
    }

    @GetMapping("/daily_intake/delete_meal/{id}")
    public String deleteMeal(@PathVariable("id") Integer id) {
        mealService.deleteById(id);
        return "redirect:/daily_intake/meals";
    }

    @GetMapping("/daily_intake/edit_meal/{id}")
    public String editMeal(@PathVariable("id") Integer id, Model model) {
        DateClass date = dateService.findById(id);
        List<Meal> meals = mealService.findAll();

        model.addAttribute("date", date);
        model.addAttribute("meals",meals);
        model.addAttribute("pagetitle","Edit Meal");
        return "edit_meal";
    }

    @GetMapping("/daily_intake/delete_meals")
    public String deleteMeals() {
        mealService.deleteAll();
        return "redirect:/daily_intake";
    }





}
