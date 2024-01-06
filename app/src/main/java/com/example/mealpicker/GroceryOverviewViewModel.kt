package com.example.mealpicker

import android.util.Log
import androidx.lifecycle.ViewModel
import data.Ingredient
import data.PlannedMeal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GroceryOverviewViewModel : ViewModel() {
    private val _GroceryOverviewUiState = MutableStateFlow(GroceryOverviewUiState(meals = PlannedMeal.getAll(), ingredients = Ingredient.getAll()))

    val groceryOverviewUiState: StateFlow<GroceryOverviewUiState> = _GroceryOverviewUiState.asStateFlow()


    init {
        Log.i("IngredientViewModel", "creating new instance $this")
    }

    fun addIngredient(
        newName: String,
        day: String,
        newList: List<Ingredient>,
    ) {
        _GroceryOverviewUiState.update {
            it.copy(
                meals = it.meals + PlannedMeal(newName, day, newList),
            )
        }
    }

}
