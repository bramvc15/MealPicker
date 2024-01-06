package com.example.mealpicker.ui.GroceryScreen

import com.example.mealpicker.model.Ingredient
import com.example.mealpicker.model.Meal
import data.IngredientSampler
import data.MealSampler

data class GroceryOverviewUiState(
    val ingredients: List<Ingredient>,
    val currentMealList: List<Meal>,
    val newMealDay: String = "",
    val newMealName: String = "",
) {
}
