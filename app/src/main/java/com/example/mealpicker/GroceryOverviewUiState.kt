package com.example.mealpicker

import data.Ingredient
import data.PlannedMeal

data class GroceryOverviewUiState(
    val meals: List<PlannedMeal> = listOf(),
    val ingredients: List<Ingredient> = listOf(),
) {
}
