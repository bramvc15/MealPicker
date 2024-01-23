package com.example.mealpicker.fake

import MealApiResponse
import com.example.mealpicker.network.APIMeal
import com.example.mealpicker.network.MealApiService

class FakeMealsApiService : MealApiService {
    override suspend fun getAllMeals(): MealApiResponse{

        return MealApiResponse(FakeDataSource.meals)
    }
    override suspend fun getRandomMeal(): APIMeal {
        throw NotImplementedError("getRandomMeal is not implemented for fake API")
    }

    override suspend fun getSeafoodMeal(): List<APIMeal> {
        return FakeDataSource.meals
    }

}
