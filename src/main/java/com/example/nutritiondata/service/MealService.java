package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.DayDAO;
import com.example.nutritiondata.dao.MealDAO;
import com.example.nutritiondata.model.Day;
import com.example.nutritiondata.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    static Integer total;

    @Autowired
    MealDAO mealDAO;

    @Autowired
    DayDAO dayDAO;

    public void save(Meal meal) {
        mealDAO.save(meal);
    }

    public List<Meal> getAllMeals() {
        return mealDAO.findAll();
    }

    public Integer totalCalories(Integer id) {
        Day day = dayDAO.getById(id);
        List<Meal> meals = day.getMeals();
        System.out.println(meals.size());

        total = 0;

        for (Meal meal : meals) {
            total += meal.getCalories();
        }

        System.out.println(total);
        return total;
    }

    public Integer totalProtein(Integer id) {
        Day day = dayDAO.getById(id);
        List<Meal> meals = day.getMeals();
        System.out.println(meals.size());

        total = 0;

        for (Meal meal : meals) {
            total += meal.getProtein();
        }

        System.out.println(total);
        return total;
    }

    public Integer totalFat(Integer id) {
        Day day = dayDAO.getById(id);
        List<Meal> meals = day.getMeals();
        System.out.println(meals.size());

        total = 0;

        for (Meal meal : meals) {
            total += meal.getFat();
        }

        System.out.println(total);
        return total;
    }

    public Integer totalCarbohydrates(Integer id) {
        Day day = dayDAO.getById(id);
        List<Meal> meals = day.getMeals();
        System.out.println(meals.size());

        total = 0;

        for (Meal meal : meals) {
            total += meal.getCarbohydrates();
        }

        System.out.println(total);
        return total;
    }

}
