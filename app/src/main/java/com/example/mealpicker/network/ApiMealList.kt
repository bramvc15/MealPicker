package com.example.mealpicker.network

import com.example.mealpicker.model.Meal
import kotlinx.serialization.Serializable

@Serializable
data class ApiMealList(
    val meals: List<Meal>
)
