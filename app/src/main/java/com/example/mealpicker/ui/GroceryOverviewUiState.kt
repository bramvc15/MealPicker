package com.example.mealpicker.ui

import com.example.mealpicker.model.Ingredient
import com.example.mealpicker.model.Meal
import data.IngredientSampler
import data.MealSampler

data class GroceryOverviewUiState(
    val meals: List<Meal> = listOf(),
    val ingredients: List<Ingredient> = listOf(),
    val currentMealList: List<Meal> = listOf(),
    val newMealDay: String = "",
    val newMealName: String = "",
) {
}
