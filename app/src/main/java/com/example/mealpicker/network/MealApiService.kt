package com.example.mealpicker.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface MealApiService {
    suspend fun getMeals():List<ApiMeals>
}

private var retrofit: Retrofit = Retrofit.Builder()
    .addConverterFactory(
        Json.asConverterFactory("application/json".toMediaType()),
    )
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .build()

object MealAPI{
    val mealService: MealApiService by lazy {
        retrofit.create(MealApiService::class.java)
    }
}