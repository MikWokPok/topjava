package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealService {
    Meal save(Meal meal);

    // false if not found
    void delete(int id);

    // null if not found
    Meal get(int id);

    Collection<Meal> getAll();
}