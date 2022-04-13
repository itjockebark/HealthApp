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

    private Integer fat;

    private Integer carbohydrates;

    @ManyToMany(mappedBy = "meals",cascade = CascadeType.PERSIST)
    private List<DayClass> days = new ArrayList<>();

    public List<DayClass> getDays() {
        return days;
    }

    public void setDays(List<DayClass> days) {
        this.days = days;
    }

    public Meal() {
    }

    public Meal(String name, Integer calories, Integer protein, Integer fat, Integer carbohydrates) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
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

    public Integer getFat() {
        return fat;
    }

    public void setFat(Integer fat) {
        this.fat = fat;
    }

    public Integer getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(Integer carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
