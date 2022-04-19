package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDAO extends JpaRepository<Schedule, Integer> {
}
