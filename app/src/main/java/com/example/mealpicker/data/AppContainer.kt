package com.example.mealpicker.data

import com.example.mealpicker.network.MealApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val mealRepository: MealRepository
}

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://www.themealdb.com/api/json/v1/1/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(
            GsonConverterFactory.create())
        .build()

    private val mealService: MealApiService by lazy {
        retrofit.create(MealApiService::class.java)
    }

    override val mealRepository: MealRepository by lazy{
        ApiMealRepository(mealService)
    }
}