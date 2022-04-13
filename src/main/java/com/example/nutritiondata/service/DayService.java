package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.DayDAO;
import com.example.nutritiondata.model.DayClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayService {

    @Autowired
    DayDAO dayDAO;

    public List<DayClass> findAll() {
        return dayDAO.findAll();
    }

    public DayClass findById(Integer id) {
        return dayDAO.findById(id).get();
    }

    public DayClass save(DayClass day) {
        DayClass savedDay = dayDAO.save(day);
        return savedDay;
    }

}
