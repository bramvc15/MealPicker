package com.example.mealpicker.ui.GroceryScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.mealpicker.MealsApplication
import com.example.mealpicker.network.asDomainObjects
import com.example.mealpicker.ui.MealApiState
import com.example.mealpicker.data.IngredientSampler
import com.example.mealpicker.data.MealRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException

class GroceryOverviewViewModel(
    private val mealRepository: MealRepository
) : ViewModel() {
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
            val result = mealRepository.getChickenMeals()

            /*_uiState.update {
                it.copy(
                    currentMealList = result,
                )
            }*/
            mealApiState = MealApiState.Success(result)
        }
    }

    fun getApiMeals() {
        viewModelScope.launch {
            val result = mealRepository.getChickenMeals()
            println("result: $result")
            /*_uiState.update {
                it.copy(
                    currentMealList = result,
                )
            }*/
            mealApiState = MealApiState.Success(result)
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = this[APPLICATION_KEY] as MealsApplication
                val mealRepository = application.container.mealRepository
                GroceryOverviewViewModel(mealRepository)
            }
        }
    }
}
