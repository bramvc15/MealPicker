package com.example.mealpicker.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.mealpicker.model.Meal
import data.IngredientSampler
import data.MealSampler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GroceryOverviewViewModel : ViewModel() {
    private val _GroceryOverviewUiState =
        MutableStateFlow(GroceryOverviewUiState(meals = MealSampler.getAll(), ingredients = IngredientSampler.getAll()))

    val groceryOverviewUiState: StateFlow<GroceryOverviewUiState> = _GroceryOverviewUiState.asStateFlow()

    init {
        Log.i("IngredientViewModel", "creating new instance $this")
    }

    fun addIngredient() {
        _GroceryOverviewUiState.update {
            currentState ->
            currentState.copy(
                currentMealList = currentState.meals + Meal(currentState.newMealName, currentState.newMealDay, currentState.ingredients),
                newMealName = "",
                newMealDay = "",
            )
        }
    }

    fun setNewMealName(name: String) {
        _GroceryOverviewUiState.update {
            it.copy(
                newMealName = name,
            )
        }
    }

    fun setNewMealDay(day: String) {
        _GroceryOverviewUiState.update {
            it.copy(
                newMealDay = day,
            )
        }
    }
}
