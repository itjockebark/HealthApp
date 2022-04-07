package com.example.nutritiondata.model;

import javax.persistence.*;


@Entity
@Table(name="meals")
public class Meal {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer calories;

    private Integer protein;

    private Integer fat;

    private Integer carbohydrates;

    @ManyToOne
    private Day day;

    public Meal() {
    }

    public Meal(Integer calories, Integer protein, Integer fat, Integer carbohydrates) {
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
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
