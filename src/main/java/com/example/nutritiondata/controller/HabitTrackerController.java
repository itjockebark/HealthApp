package com.example.nutritiondata.controller;

import com.example.nutritiondata.service.DayService;
import com.example.nutritiondata.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HabitTrackerController {

    @Autowired
    HabitService habitService;

    @Autowired
    DayService dayService;
}
