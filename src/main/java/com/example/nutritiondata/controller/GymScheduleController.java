package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.Exercise;
import com.example.nutritiondata.model.Schedule;
import com.example.nutritiondata.service.ExerciseService;
import com.example.nutritiondata.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GymScheduleController {

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/gym_schedule")
    public String gymSchedule(Model model) {
        List<Schedule> schedules = scheduleService.findAll();
        List<Exercise> exercises = exerciseService.findAll();

        model.addAttribute("schedules", schedules);
        model.addAttribute("exercises", exercises);
        return "gym_schedule";
    }
}
