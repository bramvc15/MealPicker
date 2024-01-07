package com.example.mealpicker.ui

import com.example.mealpicker.model.Meal

sealed interface MealApiState {
    object Error : MealApiState
    object Loading : MealApiState
    data class Success(val meals: Meal?) : MealApiState


}
