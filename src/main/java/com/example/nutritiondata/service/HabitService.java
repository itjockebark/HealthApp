package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.HabitDAO;
import com.example.nutritiondata.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    HabitDAO habitDAO;

    public List<Habit> findAll() {
        return habitDAO.findAll();
    }

    public void save(Habit habit) {
        habitDAO.save(habit);
    }

    public void deleteById(Integer id) {
        Habit habit = habitDAO.getById(id);
        habit.getDays().forEach(day -> day.getHabits().remove(habit));
        habitDAO.deleteById(id);
    }

    public Habit findById(Integer id) {
        return habitDAO.findById(id).get();
    }
}
