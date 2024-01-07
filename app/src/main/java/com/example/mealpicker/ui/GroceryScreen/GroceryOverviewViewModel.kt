package com.example.mealpicker.ui.GroceryScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealpicker.model.Meal
import com.example.mealpicker.network.MealAPI.mealService
import data.IngredientSampler
import data.MealSampler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GroceryOverviewViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow(GroceryOverviewUiState(currentMealList = MealSampler.getAll(), ingredients = IngredientSampler.getAll()))

    val uiState: StateFlow<GroceryOverviewUiState> = _uiState.asStateFlow()

    init {
        getApiMeals()
    }


    fun addIngredient() {
        _uiState.update {
            currentState ->
            currentState.copy(
                currentMealList = currentState.currentMealList + Meal(currentState.newMealName, currentState.newMealDay, currentState.ingredients),
                newMealName = "",
                newMealDay = "",
                doScrollCommand = currentState.doScrollCommand.plus(1),
                scrollToIndex = currentState.currentMealList.size,
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

    fun getApiMeals() {
        viewModelScope.launch{
            var result = mealService.getMeals()
            println("the tasks: $result")
        }

    }
}
