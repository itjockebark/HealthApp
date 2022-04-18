package com.example.nutritiondata.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Exercise {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private double duration;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }



}
