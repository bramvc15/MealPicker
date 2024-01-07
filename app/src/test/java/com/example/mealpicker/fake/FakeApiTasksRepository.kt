package com.example.mealpicker.fake

import com.example.mealpicker.data.MealRepository
import com.example.mealpicker.model.Meal

class FakeApiTasksRepository : MealRepository {
    override suspend fun getChickenMeals(): List<Meal>{
        TODO("")
    }
}