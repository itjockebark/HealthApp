package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.DateClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateDAO extends JpaRepository<DateClass, Integer> {
}
