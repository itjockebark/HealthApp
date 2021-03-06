package com.example.nutritiondata.service;

import com.example.nutritiondata.dao.ScheduleDAO;
import com.example.nutritiondata.model.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleDAO scheduleDAO;


    public List<Schedule> findAll() {
        return scheduleDAO.findAll();
    }

    public void save(Schedule schedule) {
        scheduleDAO.save(schedule);
    }

    public void deleteById(Integer id) {
        scheduleDAO.deleteById(id);
    }

    public Schedule findById(Integer id) {
        return scheduleDAO.findById(id).get();
    }
}
