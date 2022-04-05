package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.DayDAO;
import com.example.nutritiondata.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayService {

    @Autowired
    DayDAO dao;

    public List<Day> getAllDays() {
        return dao.findAll();
    }
}
