package com.example.mealpicker.data

import android.util.Log
import com.example.mealpicker.data.database.MealDao
import com.example.mealpicker.data.database.asDbMeal
import com.example.mealpicker.data.database.asDomainMeal
import com.example.mealpicker.data.database.asDomainMeals
import com.example.mealpicker.model.Meal
import com.example.mealpicker.network.MealApiService
import com.example.mealpicker.network.asDomainObjects
import com.example.mealpicker.network.getMealAsFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach

// om alles weg te steken van de api calls
interface MealRepository {
    suspend fun insert(item: Meal)

    fun getAllItems(): Flow<List<Meal>>

    fun getItem(id: Int): Flow<Meal>

    suspend fun refresh()
}

class CachingMealRepository(
    private val mealDao: MealDao,
    private val mealApiService: MealApiService,
) : MealRepository {

    override suspend fun insert(item: Meal) {
        mealDao.insert(item.asDbMeal())
    }

    override fun getAllItems(): Flow<List<Meal>> {
        return mealDao.getAllItems().map {
            it.asDomainMeals()
        }.onEach {
            if (it.isEmpty())
                {
                    refresh()
                }
        }
    }

    override fun getItem(id: Int): Flow<Meal> {
        return mealDao.getItem(id).map {
            it.asDomainMeal()
        }
    }

    override suspend fun refresh() {
        mealApiService.getMealAsFlow().collect {
            for (meal in it.meals.asDomainObjects()) {
                Log.i("Refresh", "refresh: $meal")
                insert(meal)
            }
        }
    }
}
