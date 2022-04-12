package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.DayDAO;
import com.example.nutritiondata.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayService {

    @Autowired
    DayDAO dayDAO;

    public List<Day> findAll() {
        return dayDAO.findAll();
    }

    public Day findById(Integer id) {
        return dayDAO.findById(id).get();
    }

    public Day save(Day day) {
        Day savedDay = dayDAO.save(day);
        return savedDay;
    }
}
