package com.example.nutritiondata.controller;

import com.example.nutritiondata.model.*;
import com.example.nutritiondata.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ManagementController {

    @Autowired
    MealService mealService;

    @Autowired
    DateService dateService;

    @Autowired
    HabitService habitService;

    @Autowired
    DayService dayService;

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ScheduleService scheduleService;

    @GetMapping("/management")
    public String management() {
        return "management";
    }

    @GetMapping("/management/meals")
    public String meals(Model model) {
        List<Meal> meals = mealService.findAll();
        model.addAttribute("meals", meals);
        return "meals";
    }

    @GetMapping("/management/meals/delete_meal/{id}")
    public String deleteMeal(@PathVariable("id") Integer id) {
        mealService.deleteById(id);
        return "redirect:/management/meals";
    }

    @GetMapping("/management/meals/meal_registration")
    public String mealRegistration(Model model) {
        model.addAttribute("meal", new Meal());
        model.addAttribute("pagetitle","Meal Registration");
        return "meal_registration";
    }

    @PostMapping("/management/meals/save_meal")
    public String saveMeal(Meal meal) {
        mealService.save(meal);
        return "redirect:/management/meals";
    }

    @GetMapping("/management/habits")
    public String showAllHabits(Model model) {
        List<Habit> habits = habitService.findAll();
        model.addAttribute("habits", habits);
        return "habits";
    }

    @GetMapping("/management/habits/delete_habit/{id}")
    public String deleteHabit(@PathVariable("id") Integer id) {
        habitService.deleteById(id);
        return "redirect:/management/habits";
    }

    @GetMapping("/management/habits/habit_registration")
    public String habitRegistration(Model model) {
        model.addAttribute("habit", new Habit());
        model.addAttribute("pagetitle", "Habit Registration");
        return "habit_registration";
    }

    @PostMapping("/management/habits/save_habit")
    public String saveHabit(Habit habit) {
        habitService.save(habit);
        return "redirect:/management/habits";
    }

    @GetMapping("/management/dates")
    public String dates(Model model) {
        List<DateClass> dates = dateService.findAll();
        model.addAttribute("dates", dates);
        return "dates";
    }

    @GetMapping("/management/dates/date_registration")
    public String dateRegistration(Model model) {
        List<DayClass> days = dayService.findAll();
        model.addAttribute("days", days);
        model.addAttribute("date", new DateClass());
        model.addAttribute("pagetitle", "Date Registration");
        return "date_registration";
    }

    @PostMapping("/management/dates/save_date")
    public String saveDate(DateClass date) {
        dateService.save(date);
        return "redirect:/management/dates";
    }

    @PostMapping("/management/dates/save_edit_date")
    public String saveEditDate(DateClass date) {
        List<Meal> meals = dateService.findConnectedMeals(date.getId());
        List<Habit> habits = dateService.findConnectedHabits(date.getId());

        date.setMeals(meals);
        date.setHabits(habits);

        dateService.save(date);
        return "redirect:/management/dates";
    }

    @GetMapping("/management/dates/delete_date/{id}")
    public String deleteDate(@PathVariable("id") Integer id) {
        dateService.deleteById(id);
        return "redirect:/management/dates";
    }

    @GetMapping("/management/dates/edit_date/{id}")
    public String dates(@PathVariable("id") Integer id, Model model) {
        DateClass date = dateService.findById(id);
        List<DayClass> days = dayService.findAll();

        model.addAttribute("days", days);
        model.addAttribute("date", date);
        model.addAttribute("pagetitle", "Edit Date");
        return "edit_date";
    }

    @GetMapping("/management/meals/edit_meal/{id}")
    public String editMeal(@PathVariable("id") Integer id, Model model) {
        Meal meal = mealService.findById(id);
        model.addAttribute("meal", meal);
        model.addAttribute("pagetitle", "Edit Meal");
        return "meal_registration";
    }

    @GetMapping("/management/habits/edit_habit/{id}")
    public String editHabit(@PathVariable("id") Integer id, Model model) {
        Habit habit = habitService.findById(id);
        model.addAttribute("habit", habit);
        model.addAttribute("pagetitle", "Edit Habit");
        return "habit_registration";
    }

    @GetMapping("/management/exercises/edit_exercise/{id}")
    public String editExercise(@PathVariable("id") Integer id, Model model) {
        Exercise exercise = exerciseService.findById(id);
        model.addAttribute("exercise", exercise);
        model.addAttribute("pagetitle", "Edit Exercise");
        return "exercise_registration";
    }

    @GetMapping("/management/exercises")
    public String exercises(Model model) {
        List<Exercise> exercises = exerciseService.findAll();
        model.addAttribute("exercises", exercises);
        return "exercises";
    }

    @GetMapping("/management/exercises/exercise_registration")
    public String exerciseRegistration(Model model) {
        model.addAttribute("exercise", new Exercise());
        return "exercise_registration";
    }



    @PostMapping("/management/exercises/save_exercise")
    public String saveExercise(Exercise exercise) {
        exerciseService.save(exercise);
        return "redirect:/management/exercises";
    }

    @GetMapping("/management/exercises/delete_exercise/{id}")
    public String deleteExercise(@PathVariable("id") Integer id) {
        exerciseService.deleteById(id);
        return "redirect:/management/exercises";
    }

    @GetMapping("/management/schedules")
    public String schedules(Model model) {
        List<Schedule> schedules = scheduleService.findAll();
        model.addAttribute("schedules", schedules);
        return "schedules";
    }

    @GetMapping("/management/schedules/schedule_registration")
    public String scheduleRegistration(Model model) {
        model.addAttribute("schedule", new Schedule());
        model.addAttribute("pagetitle", "Schedule Registration");
        return "schedule_registration";
    }

    @PostMapping("/management/schedules/save_schedule")
    public String saveSchedule(Schedule schedule) {
        scheduleService.save(schedule);
        return "redirect:/management/schedules";
    }

    @GetMapping("/management/schedules/delete_schedule/{id}")
    public String deleteSchedule(@PathVariable("id") Integer id) {
        scheduleService.deleteById(id);
        return "redirect:/management/schedules";
    }

    @GetMapping("/management/schedules/edit_schedule/{id}")
    public String editSchedule(@PathVariable("id") Integer id, Model model) {
        Schedule schedule = scheduleService.findById(id);
        model.addAttribute("schedule", schedule);
        model.addAttribute("pagetitle", "Edit Schedule");
        return "schedule_registration";
    }
}
