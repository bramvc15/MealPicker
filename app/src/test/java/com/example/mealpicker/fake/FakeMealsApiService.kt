package com.example.mealpicker.fake

import com.example.mealpicker.network.APIMeal
import com.example.mealpicker.network.MealApiService


class FakeMealsApiService : MealApiService {
    override suspend fun getRandomMeal(): APIMeal {
        TODO("Not yet implemented")
    }

    override suspend fun getSeafoodMeal(): List<APIMeal> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllMeals(): List<APIMeal> {
        return FakeDataSource.meals
    }
}