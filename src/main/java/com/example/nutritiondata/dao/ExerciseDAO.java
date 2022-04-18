package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseDAO extends JpaRepository<Exercise, Integer> {
}
