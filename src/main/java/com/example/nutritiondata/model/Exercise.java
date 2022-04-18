package com.example.nutritiondata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private double duration;

    @ManyToMany
    List<DateClass> dates = new ArrayList<>();

    public Exercise() {
    }

    public Exercise(String name, double duration) {
        this.name = name;
        this.duration = duration;
    }

    public List<DateClass> getDates() {
        return dates;
    }

    public void setDates(List<DateClass> dates) {
        this.dates = dates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }



}
