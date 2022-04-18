package com.example.nutritiondata.controller;

import com.example.nutritiondata.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GymScheduleController {

    @Autowired
    ExerciseService exerciseService;

    @GetMapping("/gym_schedule")
    public String gymSchedule(Model model) {
        return "gym_schedule";
    }
}
