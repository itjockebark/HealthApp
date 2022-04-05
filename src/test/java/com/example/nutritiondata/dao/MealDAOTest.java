package com.example.nutritiondata.dao;

import com.example.nutritiondata.model.Meal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
@DataJpaTest
class MealDAOTest {

    @Autowired
    MealDAO dao;

    @Test
    public void testAddMeal() {
        Meal meal = new Meal();

        meal.setCalories(600);
        meal.setProtein(200);
        meal.setFat(25);
        meal.setCarbohydrates(0);

        dao.save(meal);

        assertThat(meal.getCalories().equals(600));
    }
}