package com.example.mealpicker.ui.GroceryScreen

import com.example.mealpicker.model.Ingredient

data class GroceryOverviewUiState(
    val ingredients: List<Ingredient> ,
    val newDescription: String = "",
    val newMealName: String = "",
    val doScrollCommand: Int = 0,
    val scrollToIndex: Int = 0,
) {
}
