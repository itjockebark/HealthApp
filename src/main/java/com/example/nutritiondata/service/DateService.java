package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.DateDAO;
import com.example.nutritiondata.model.DateClass;
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
}
