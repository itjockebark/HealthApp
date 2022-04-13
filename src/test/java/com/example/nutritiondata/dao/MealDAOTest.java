package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.Meal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
@DataJpaTest
class MealDAOTest {

    @Autowired
    MealDAO dao;

    @Test
    public void testAddMeal() {
        Meal meal = new Meal("Potatis",600,200);

        dao.save(meal);

        assertThat(meal.getCalories().equals(600));
    }

    @Test
    public void findAll() {
        List<Meal> meals = dao.findAll();

        assertThat(meals.size()).isEqualTo(1);
    }

    @Test
    public void findById() {
        Meal meal = dao.findById(1).get();

        assertThat(meal.getName().compareTo("Köttbullar och potatis"));
    }

    @Test
    public void testDeleteAll() {
        Meal meal1 = new Meal("Hamburgare",600,200);
        Meal meal2 = new Meal("Toast Skagen",500,150);

        dao.save(meal1);
        dao.save(meal2);

        assertThat(meal1.getCalories().equals(600));
        assertThat(meal2.getCalories().equals(500));

        dao.deleteAll();

        assertThat(meal1.getCalories().equals(0));
        assertThat(meal2.getCalories().equals(0));
    }

    @Test
    public void deleteById() {
        Meal meal = new Meal("Potatis",600,200);

        dao.save(meal);

        Meal foundMeal = dao.findById(meal.getId()).get();
        System.out.println(foundMeal.getId());

        assertThat(foundMeal.getId().equals(9));

        dao.deleteById(foundMeal.getId());

        assertThat(foundMeal.getId().equals(0));
    }

    @Test
    public void totalCalories() {
        Meal meal1 = new Meal("Potatis",600,200);
        Meal meal2 = new Meal("Toast Skagen",500,150);

        List<Meal> meals = new ArrayList<>();

        meals.add(meal1);
        meals.add(meal2);

        Integer totalCalories = 0;

        for (Meal meal : meals) {
            totalCalories += meal.getCalories();
        }

        assertThat(totalCalories.equals(1100));
    }
}