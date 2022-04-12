package com.example.nutritiondata.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "days")
public class Day {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate date;

    @ManyToMany
    private List<Meal> meals = new ArrayList<>();

    @ManyToMany()
    private List<Habit> habits = new ArrayList<>();

    public Day() {
    }

    public Day(String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        this.date = parsedDate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(String date) {
        LocalDate dayDate = LocalDate.parse(date);
        this.date = dayDate;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }


    public List<Habit> getHabits() {
        return habits;
    }

    public void setHabits(List<Habit> habits) {
        this.habits = habits;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
