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

    public void vad() {
        Day day = dayDAO.getById(2);
        int totalCalories = 0;
        for (Meal meal:day.getMeals()) {

        }
    }

}
