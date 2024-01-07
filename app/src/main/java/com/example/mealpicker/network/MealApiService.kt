package com.example.mealpicker.network

import MealApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(
        GsonConverterFactory.create())
    .build()

object MealApi {
    val mealService: MealApiService by lazy {
        retrofit.create(MealApiService::class.java)
    }
}

interface MealApiService {
    @GET("random.php")
    suspend fun getRandomMeal(): APIMeal

    @GET("filter.php?c=Seafood")
    suspend fun getSeafoodMeal(): List<APIMeal>
    @GET("filter.php?i=chicken_breast")
    suspend fun getChickenMeals(): MealApiResponse

}


