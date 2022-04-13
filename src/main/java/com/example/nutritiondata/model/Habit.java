package com.example.nutritiondata.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "habits")
public class Habit {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "habits", cascade = CascadeType.PERSIST)
    private List<DayClass> days = new ArrayList<>();

    public Habit() {
    }

    public Habit(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DayClass> getDays() {
        return days;
    }

    public void setDays(List<DayClass> days) {
        this.days = days;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
