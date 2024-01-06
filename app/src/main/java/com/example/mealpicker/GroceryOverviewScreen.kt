package com.example.mealpicker

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import data.Ingredient
import data.PlannedMeal

@Composable
fun GroceryOverviewScreen(
    addingMeal: Boolean,
    stopAdding: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val viewModel: GroceryOverviewViewModel = viewModel()
    val groceryOverviewUiState by viewModel.groceryOverviewUiState.collectAsState()
    val ingredients = groceryOverviewUiState.ingredients
    Log.i("GroceryOverviewScreen", "ingredients: $ingredients")
    val meals = groceryOverviewUiState.meals


    Box(modifier = modifier) {
        if (addingMeal) {
            var name by remember {
                mutableStateOf("flower")
            }
            var day by remember {
                mutableStateOf("Monday")
            }

            UpdateMeal(
                name,
                onChangeName = { name = it },
                onAdd = {
                    viewModel.addIngredient(name, day, listOf(Ingredient.getOne()))
                    stopAdding()
                },
            )
        } else {
            LazyColumn {
                items(meals) {
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
fun AllPlannedMeals(meals: List<PlannedMeal>) {
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
