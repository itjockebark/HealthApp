package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.DateClass;
import com.example.nutritiondata.model.Exercise;
import com.example.nutritiondata.model.Meal;
import com.example.nutritiondata.model.Schedule;
import com.example.nutritiondata.service.ExerciseService;
import com.example.nutritiondata.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @GetMapping("/gym_schedule/edit_gym_schedule/{id}")
    public String editMeal(@PathVariable("id") Integer id, Model model) {
        Schedule schedule = scheduleService.findById(id);
        List<Exercise> exercises = exerciseService.findAll();

        model.addAttribute("schedule", schedule);
        model.addAttribute("exercises",exercises);
        model.addAttribute("pagetitle","Edit Schedule");
        return "edit_gym_schedule";
    }

    @PostMapping("/gym_schedule/save_gym_schedule")
    public String saveGymSchedule(Schedule schedule) {
        scheduleService.save(schedule);
        return "redirect:/gym_schedule";
    }

    @GetMapping("/gym_schedule/connected_exercises/{id}")
    public String connectedExercises(@PathVariable("id") Integer id, Model model) {
        Schedule schedule = scheduleService.findById(id);
        List<Exercise> exercises = schedule.getExercises();
        model.addAttribute("schedule", schedule);
        model.addAttribute("exercises", exercises);
        return "connected_exercises";
    }
}
