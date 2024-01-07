package com.example.mealpicker.data

import com.example.mealpicker.model.Meal
import com.example.mealpicker.network.MealApiService
import com.example.mealpicker.network.asDomainObjects

//om alles weg te steken van de api calls
interface MealRepository {
    suspend fun getMeals(): List<Meal>
}

class ApiMealsRepository(
    private val mealApiService: MealApiService
): MealRepository {
    override suspend fun getMeals(): List<Meal> {
        return mealApiService.getChickenMeals().meals.asDomainObjects()
    }
}
