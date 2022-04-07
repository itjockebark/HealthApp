package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.HabitDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabitService {

    @Autowired
    HabitDAO habitDAO;
}
