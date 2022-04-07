package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealDAO extends JpaRepository<Meal, Integer> {

}
