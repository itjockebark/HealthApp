package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.Meal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback
@DataJpaTest
class MealDAOTest {

    @Autowired
    MealDAO dao;

    @Test
    public void testAddMeal() {
        Meal meal = new Meal("Potatis",600,200,25,0);

        dao.save(meal);

        assertThat(meal.getCalories().equals(600));
    }

    @Test
    public void testDeleteAll() {
        Meal meal1 = new Meal("Hamburgare",600,200,25,2);
        Meal meal2 = new Meal("Toast Skagen",500,150,15,1);

        dao.save(meal1);
        dao.save(meal2);

        assertThat(meal1.getCalories().equals(600));
        assertThat(meal2.getCalories().equals(500));

        dao.deleteAll();

        assertThat(meal1.getCalories().equals(0));
        assertThat(meal2.getCalories().equals(0));
    }
}