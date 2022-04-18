package com.example.nutritiondata.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="meals")
public class Meal {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private Integer calories;

    private Integer protein;

    @ManyToMany(mappedBy = "meals")
    private List<DateClass> dates = new ArrayList<>();

    public List<DateClass> getDates() {
        return dates;
    }

    public void setDates(List<DateClass> dates) {
        this.dates = dates;
    }

    public Meal() {
    }

    public Meal(String name, Integer calories, Integer protein) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getProtein() {
        return protein;
    }

    public void setProtein(Integer protein) {
        this.protein = protein;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
