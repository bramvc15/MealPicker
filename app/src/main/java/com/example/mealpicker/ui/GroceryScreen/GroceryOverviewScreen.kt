package com.example.mealpicker.ui.GroceryScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealpicker.model.Meal
import com.example.mealpicker.model.MealList
import com.example.mealpicker.ui.IngredientItem
import com.example.mealpicker.ui.MealApiState
import com.example.mealpicker.ui.MealItem

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
        var listState = rememberLazyListState()
        /*Column {
            Text(
                text = "All planned meals",
                fontSize = 26.sp,
                lineHeight = 40.sp,
            )
            Spacer(modifier = Modifier.height(25.dp))
        }*/
        LazyColumn(state = listState) {
            /*items(groceryOverviewUiState.currentMealList) {
                MealItem(name = it.name, day = it.day)
            }*/
            val mealApiState = viewModel.mealApiState
            when (mealApiState) {
                is MealApiState.Loading -> {
                    item {
                        Text(text = "Loading task form API...")
                    }
                }
                is MealApiState.Success -> {
                    item{
                        println("mealllllllll: ${mealApiState.meals}")
                        mealApiState.meals?.let { IngredientItem(name = it.name, instruction = mealApiState.meals.instruction) }
                    }
                }
                is MealApiState.Error -> {
                    item {
                        Text(text = "Error loading task form API...")
                    }
                }
            }
        }
        LaunchedEffect(groceryOverviewUiState.doScrollCommand) {
            listState.animateScrollToItem(groceryOverviewUiState.scrollToIndex)
        }

        /*Column {
            Text(
                text = "Grocery list",
                fontSize = 26.sp,
                lineHeight = 20.sp,
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.height(25.dp))
        }*/
        if (addingMeal) {
            UpdateMeal(
                day = groceryOverviewUiState.newMealDay,
                name = groceryOverviewUiState.newMealName,
                onChangeName = { viewModel.setNewMealName(it) },
                onChangeDay = { viewModel.setNewMealDay(it) },
                onAdd = {
                    viewModel.addIngredient()
                    stopAdding()
                },
                {
                    stopAdding()
                },
            )
        }
    }
}
