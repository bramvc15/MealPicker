package com.example.mealpicker.fake

import com.example.mealpicker.data.MealRepository
import com.example.mealpicker.model.Meal
import com.example.mealpicker.network.asDomainObjects
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow

class FakeApiMealsRepository : MealRepository {


    override suspend fun insert(item: Meal) {
        // Not implemented for fake repository
    }

    override fun getAllItems(): Flow<List<Meal>> {
        return flow {
            emit(FakeDataSource.meals.asDomainObjects())
        }
    }

    override fun getItem(id: Int): Flow<Meal> {
        // Not implemented for fake repository
        throw NotImplementedError("getItem is not implemented for fake repository")
    }

    override suspend fun refresh() {
        // Not implemented for fake repository
    }
}
