package com.example.mealpicker.network

import MealApiResponse
import kotlinx.coroutines.flow.flow
import retrofit2.http.GET

interface MealApiService {
    @GET("random.php")
    suspend fun getRandomMeal(): APIMeal

    @GET("filter.php?c=Seafood")
    suspend fun getSeafoodMeal(): List<APIMeal>
    @GET("filter.php?i=chicken_breast")
    suspend fun getAllMeals(): MealApiResponse

}

fun MealApiService.getMealAsFlow() = flow { emit(getAllMeals()) }

