package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.Day;
import com.example.nutritiondata.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DayDAO extends JpaRepository<Day,Integer> {

}
