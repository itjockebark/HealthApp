package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateDAO extends JpaRepository<Date, Integer> {
}
