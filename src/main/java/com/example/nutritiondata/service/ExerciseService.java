package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.ExerciseDAO;
import com.example.nutritiondata.model.Exercise;
import com.example.nutritiondata.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    ExerciseDAO exerciseDAO;

    public List<Exercise> findAll() {
        return exerciseDAO.findAll();
    }

    public void save(Exercise exercise) {
        exerciseDAO.save(exercise);
    }

    public void deleteById(Integer id) {
        exerciseDAO.deleteById(id);
    }
}
