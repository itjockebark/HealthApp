package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.MealDAO;
import com.example.nutritiondata.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    MealDAO dao;

    public void save(Meal meal) {
        dao.save(meal);
    }
}
