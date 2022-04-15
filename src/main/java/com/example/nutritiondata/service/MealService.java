package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.DateDAO;
import com.example.nutritiondata.dao.MealDAO;
import com.example.nutritiondata.model.DateClass;
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
    DateDAO dateDAO;

    public void save(Meal meal) {
        mealDAO.save(meal);
    }

    public List<Meal> findAll() {
        return mealDAO.findAll();
    }

    public void deleteById(Integer id) {
        mealDAO.deleteById(id);
    }

    public Meal findById(Integer id) {
        return mealDAO.findById(id).get();
    }


    public Integer totalCalories(Integer id) {
        DateClass date = dateDAO.getById(id);

        List<Meal> meals = date.getMeals();

        total = 0;

        meals.stream().forEach(meal -> total += meal.getCalories());
        return total;
    }

    public Integer totalProtein(Integer id) {
        DateClass date = dateDAO.getById(id);

        List<Meal> meals = date.getMeals();

        total = 0;

        meals.stream().forEach(meal -> total += meal.getProtein());
        return total;
    }

    public void deleteAll() {
        mealDAO.deleteAll();
    }
}
