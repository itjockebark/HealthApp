package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayDAO extends JpaRepository<Day,Integer> {

}
