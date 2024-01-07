package com.example.mealpicker.network

import MealApiResponse
import retrofit2.http.GET

interface MealApiService {
    @GET("random.php")
    suspend fun getRandomMeal(): APIMeal

    @GET("filter.php?c=Seafood")
    suspend fun getSeafoodMeal(): List<APIMeal>
    @GET("filter.php?i=chicken_breast")
    suspend fun getChickenMeals(): MealApiResponse

}
//1:05:00

