package com.example.nutritiondata.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "days")
public class DayClass {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany
    private List<Meal> meals = new ArrayList<>();

    @ManyToMany()
    private List<Habit> habits = new ArrayList<>();

    @OneToMany(mappedBy = "day",cascade = CascadeType.PERSIST)
    private List<DateClass> dates = new ArrayList<>();

    public DayClass() {
    }

    public DayClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DateClass> getDates() {
        return dates;
    }

    public void setDates(List<DateClass> dates) {
        this.dates = dates;
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
