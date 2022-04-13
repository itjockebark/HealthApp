package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.DayClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayDAO extends JpaRepository<DayClass,Integer> {

}
