package com.example.mealpicker.fake

import com.example.mealpicker.data.MealRepository
import com.example.mealpicker.model.Meal
import com.example.mealpicker.network.asDomainObjects

class FakeApiMealsRepository : MealRepository {
    override suspend fun getChickenMeals(): List<Meal>{
        return FakeDataSource.meals.asDomainObjects()
    }
}