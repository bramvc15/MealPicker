package com.example.mealpicker.ui.GroceryScreen

import com.example.mealpicker.model.Ingredient
import com.example.mealpicker.model.Meal

data class GroceryOverviewUiState(
    val ingredients: List<Ingredient>,
    val currentMealList: List<Meal>,
    val newMealDay: String = "",
    val newMealName: String = "",
    val doScrollCommand: Int = 0,
    val scrollToIndex: Int = 0,
) {
}
