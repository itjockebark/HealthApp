package com.example.nutritiondata.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dates")
public class DateClass {

    @Id
    @GeneratedValue
    private Integer id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @ManyToOne
    @JoinColumn(name="day_id")
    DayClass day = new DayClass();

    @ManyToMany
    private List<Meal> meals = new ArrayList<>();

    @ManyToMany()
    private List<Habit> habits = new ArrayList<>();

    public DateClass(Date date) {
        this.date = date;
    }

    public DateClass() {
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

    public DayClass getDay() {
        return day;
    }

    public void setDay(DayClass day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
