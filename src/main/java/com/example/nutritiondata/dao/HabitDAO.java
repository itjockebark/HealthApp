package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitDAO extends JpaRepository<Habit, Integer> {
}
