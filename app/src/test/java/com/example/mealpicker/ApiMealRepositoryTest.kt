package com.example.mealpicker

import com.example.mealpicker.data.MealRepository
import com.example.mealpicker.fake.FakeApiMealsRepository
import com.example.mealpicker.fake.FakeDataSource
import com.example.mealpicker.model.Meal
import com.example.mealpicker.network.asDomainObjects
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ApiMealRepositoryTest {
    @Test
    fun apiMealRepository_getMeals_verifyMealsList() = runTest {
        val mealRepository: MealRepository = FakeApiMealsRepository()

        val actualMeals = mutableListOf<List<Meal>>()

        mealRepository.getAllItems().collect {
            actualMeals.add(it)
        }

        assertEquals(FakeDataSource.meals.asDomainObjects(), actualMeals[0])
    }
}
