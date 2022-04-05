package com.example.nutritiondata.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "days")
public class Day {
    @Id
    private String name;

    @OneToMany()
    private List<Meal> meals = new ArrayList<>();

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public Day() {
    }

    public Day(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
