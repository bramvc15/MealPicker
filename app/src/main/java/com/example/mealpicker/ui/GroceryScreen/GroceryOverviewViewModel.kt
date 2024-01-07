package com.example.mealpicker.ui.GroceryScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealpicker.network.MealApi.mealService
import com.example.mealpicker.network.asDomainObject
import com.example.mealpicker.network.asDomainObjects
import com.example.mealpicker.ui.MealApiState
import data.IngredientSampler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.function.Consumer

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
            try {
                val result = mealService.getSeafoodMeal()
                mealApiState = MealApiState.Success(result.asDomainObjects())
            } catch (e: Exception) {
                println("Error: $e")
                mealApiState = MealApiState.Error
            }
        }
    }
    fun getApiMeals() {
        viewModelScope.launch {

            val result = mealService.getChickenMeals()
            mealApiState = MealApiState.Success(result.meals.asDomainObjects())
            result.meals[0].Ingredients.forEach(Consumer {
                println("ingredient: $it")
            })

        }
    }
    /*fun getApiMeals() {
        RetrofitInstance.api.getRandomMeal().enqueue(object: Callback<MealList>{
            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {
                if(response.body() != null){
                    val randomMeal:Meal = response.body()!!.meals[0]
                    Log.d("Random Meal", "meal id ${ randomMeal.idMeal } name ${ randomMeal.strMeal }")
                }else{
                    return
                }
            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.d("Random Meal", "Error: ${ t.message.toString() }")
            }
        })

    }*/
}
