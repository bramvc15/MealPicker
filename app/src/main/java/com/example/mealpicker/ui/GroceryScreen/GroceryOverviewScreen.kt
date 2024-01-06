package com.example.mealpicker.ui.GroceryScreen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealpicker.ui.IngredientItem
import com.example.mealpicker.ui.MealItem
import com.example.mealpicker.ui.UpdateMeal
import data.MealSampler

@Composable
fun GroceryOverviewScreen(
    addingMeal: Boolean,
    stopAdding: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val viewModel: GroceryOverviewViewModel = viewModel()
    val groceryOverviewUiState by viewModel.uiState.collectAsState()
    val ingredients = groceryOverviewUiState.ingredients


    Box(modifier = modifier) {
        if (addingMeal) {

            UpdateMeal(
                day = groceryOverviewUiState.newMealDay,
                name = groceryOverviewUiState.newMealName,
                onChangeName = { viewModel.setNewMealName(it) },
                onChangeDay = { viewModel.setNewMealDay(it)},
                onAdd = {
                    viewModel.addIngredient()
                    stopAdding()
                },
            )
        } else {
            LazyColumn {
                items(groceryOverviewUiState.currentMealList) {
                    MealItem(name = it.name, day = it.day)
                }

                items(ingredients) {
                    IngredientItem(name = it.name, instruction = it.instruction)
                }
            }
        }
    }
}

@Composable
fun AllPlannedMeals(meals: List<MealSampler>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "All planned meals",
            fontSize = 26.sp,
            lineHeight = 40.sp,
        )
        for (meal in meals) {
            MealItem(name = meal.name, day = meal.day)
        }

        Text(
            text = "Grocery list",
            fontSize = 26.sp,
            lineHeight = 20.sp,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}
