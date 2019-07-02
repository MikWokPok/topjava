package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
    }

    public static HashMap<List<UserMeal>,Integer> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMeal> mealListWithSort = new ArrayList<>();
        HashMap<List<UserMeal>,Integer> userMealListMapWithCalories = new HashMap<>();

        int caloriesPerDayList = 0;

        for (UserMeal userMeal : mealList) {
            int userMealHour = userMeal.getDateTime().toLocalTime().getHour();
            int userMealMin = userMeal.getDateTime().toLocalTime().getMinute();

            if (userMealHour > startTime.getHour() && userMealMin >= startTime.getMinute() && userMealHour < endTime.getHour() && userMealMin <= endTime.getMinute()){
                mealListWithSort.add(userMeal);
                caloriesPerDayList  += userMeal.getCalories() ;

            }
        }
        userMealListMapWithCalories.put(mealListWithSort,caloriesPerDayList);
        return userMealListMapWithCalories;
    }
}
