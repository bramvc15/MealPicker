package com.example.mealpicker.data

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.mealpicker.data.database.MealDao
import com.example.mealpicker.data.database.MealDatabase
import com.example.mealpicker.network.MealApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppContainer {
    val mealRepository: MealRepository
}

class DefaultAppContainer(
    applicationContext: Context
) : AppContainer {
    private val baseUrl = "https://www.themealdb.com/api/json/v1/1/"
    private val retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(
            GsonConverterFactory.create())
        .build()

    private val mealService: MealApiService by lazy {
        Log.d("APIMeal", "Retrofit initialized")
        retrofit.create(MealApiService::class.java)
    }

    private val mealDb: MealDatabase by lazy {
        Room.databaseBuilder(applicationContext,MealDatabase::class.java, "meal_database")
            .build()
    }

    private val mealDao: MealDao by lazy {
       mealDb.mealDao()
    }

    override val mealRepository: MealRepository by lazy{
        //ApiMealRepository(mealService)
        CachingMealRepository(mealDao = mealDao, mealApiService = mealService)
    }
}