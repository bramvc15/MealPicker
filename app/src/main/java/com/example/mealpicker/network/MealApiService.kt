package com.example.mealpicker.network

import MealApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query



interface MealApiService {
    @GET("random.php")
    suspend fun getRandomMeal(): APIMeal

    @GET("filter.php?c=Seafood")
    suspend fun getSeafoodMeal(): List<APIMeal>
    @GET("filter.php?i=chicken_breast")
    suspend fun getChickenMeals(): MealApiResponse

}


