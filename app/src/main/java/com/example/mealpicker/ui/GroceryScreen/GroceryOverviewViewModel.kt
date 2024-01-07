package com.example.mealpicker.ui.GroceryScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealpicker.network.MealApi.mealService
import com.example.mealpicker.network.asDomainObjects
import com.example.mealpicker.ui.MealApiState
import data.IngredientSampler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class GroceryOverviewViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow(GroceryOverviewUiState(currentMealList = listOf(), ingredients = IngredientSampler.getAll()))

    val uiState: StateFlow<GroceryOverviewUiState> = _uiState.asStateFlow()

    var mealApiState: MealApiState by mutableStateOf(MealApiState.Loading)
        private set

    init {
        getApiMeals()
    }

    fun addIngredient() {
        _uiState.update {
                currentState ->
            currentState.copy(
                currentMealList = currentState.currentMealList,
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

    fun getSeafoodMeals() {
        viewModelScope.launch {
            val result = mealService.getSeafoodMeal()
            mealApiState = MealApiState.Success(result.asDomainObjects())
        }
    }

    fun getApiMeals() {
        viewModelScope.launch {
            try {
                val result = mealService.getChickenMeals()
                mealApiState = MealApiState.Success(result.meals.asDomainObjects())
            } catch (e: SocketTimeoutException) {
                mealApiState = MealApiState.Error
            }
        }
    }
}
