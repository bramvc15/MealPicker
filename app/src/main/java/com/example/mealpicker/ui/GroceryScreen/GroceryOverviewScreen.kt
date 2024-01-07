package com.example.mealpicker.ui.GroceryScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mealpicker.model.Meal
import com.example.mealpicker.ui.IngredientItem
import com.example.mealpicker.ui.MealApiState
import kotlinx.coroutines.flow.StateFlow

@Composable
fun GroceryOverviewScreen(
    modifier: Modifier = Modifier,
    addingMeal: Boolean,
    stopAdding: () -> Unit,
    viewModel: GroceryOverviewViewModel = viewModel(factory = GroceryOverviewViewModel.Factory),
) {
    val groceryOverviewUiState by viewModel.uiState.collectAsState()
    val ingredients = groceryOverviewUiState.ingredients
    var listState = rememberLazyListState()
    val mealApiState = viewModel.mealApiState
    val uiListState by viewModel.uiListState.collectAsState()

    Box(modifier = modifier) {
            when (mealApiState) {
                is MealApiState.Loading -> {

                        Text(text = "Loading task form API...")

                }
                is MealApiState.Success -> {
                    MealList(
                        mealOverviewState = groceryOverviewUiState,
                        uiListState = uiListState,
                    )

                }
                is MealApiState.Error -> {

                        Text(text = "Error loading task form API...")

                }
            }

        LaunchedEffect(groceryOverviewUiState.doScrollCommand) {
            listState.animateScrollToItem(groceryOverviewUiState.scrollToIndex)
        }
        if (addingMeal) {
            UpdateMeal(
                day = groceryOverviewUiState.newDescription,
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
@Composable
fun MealList(
    modifier: Modifier = Modifier,
    mealOverviewState: GroceryOverviewUiState,
    uiListState: List<Meal>,
) {
    val lazyListState = rememberLazyListState()
    LazyColumn(state = lazyListState) {
        items(uiListState) {
            IngredientItem(name = it.name, instruction = it.instruction)
        }

    }
}
