package com.example.mealpicker

import com.example.mealpicker.data.ApiMealRepository
import com.example.mealpicker.fake.FakeDataSource
import com.example.mealpicker.fake.FakeMealsApiService
import com.example.mealpicker.network.asDomainObjects
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ApiMealRepositoryTest {
    @Test
    fun apiMealRepository_getMeals_verifyMealsList() = runTest {
        val repository = ApiMealRepository(FakeMealsApiService())

        assertEquals(FakeDataSource.meals.asDomainObjects(), repository.getChickenMeals())
    }
}