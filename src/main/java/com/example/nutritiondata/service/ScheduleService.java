package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.ScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    ScheduleDAO scheduleDAO;


}
