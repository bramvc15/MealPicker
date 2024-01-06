package com.example.mealpicker.ui.GroceryScreen

import androidx.lifecycle.ViewModel
import com.example.mealpicker.model.Meal
import data.IngredientSampler
import data.MealSampler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GroceryOverviewViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow(GroceryOverviewUiState(currentMealList = MealSampler.getAll(), ingredients = IngredientSampler.getAll()))

    val uiState: StateFlow<GroceryOverviewUiState> = _uiState.asStateFlow()


    fun addIngredient() {
        _uiState.update {
            currentState ->
            currentState.copy(
                currentMealList = currentState.currentMealList + Meal(currentState.newMealName, currentState.newMealDay, currentState.ingredients),
                newMealName = "",
                newMealDay = "",
            )
        }
    }

    fun setNewMealName(name: String) {
        _uiState.update {
            it.copy(
                newMealName = name,
            )
        }
    }

    fun setNewMealDay(day: String) {
        _uiState.update {
            it.copy(
                newMealDay = day,
            )
        }
    }
}
