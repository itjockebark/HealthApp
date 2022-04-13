package com.example.nutritiondata.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dates")
public class Date {

    @Id
    @GeneratedValue
    private Integer id;

    private LocalDate date;

    @ManyToMany(mappedBy = "dates", cascade = CascadeType.PERSIST)
    List<Day> days = new ArrayList<>();

    public Date(String date) {
        LocalDate parsedDate = LocalDate.parse(date);
        this.date = parsedDate;
    }

    public Date() {
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDate(String date) {
        LocalDate dayDate = LocalDate.parse(date);
        this.date = dayDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
