package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.DateDAO;
import com.example.nutritiondata.model.DateClass;
import com.example.nutritiondata.model.Habit;
import com.example.nutritiondata.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DateService {

    @Autowired
    DateDAO dateDAO;

    public List<DateClass> findAll() {
        return dateDAO.findAll();
    }

    public void save(DateClass date) {
        dateDAO.save(date);
    }

    public void deleteById(Integer id) {
        dateDAO.deleteById(id);
    }

    public List<Meal> findConnectedMeals(Integer id) {
        DateClass date = dateDAO.findById(id).get();
        List<Meal> meals = date.getMeals();
        return meals;
    }

    public List<Habit> findConnectedHabits(Integer id) {
        DateClass date = dateDAO.findById(id).get();
        List<Habit> habits = date.getHabits();
        return habits;
    }


    public DateClass findById(Integer id) {
        return dateDAO.findById(id).get();
    }
}
