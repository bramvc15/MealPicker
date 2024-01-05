package com.example.mealpicker

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.mealpicker.data.Ingredient
import com.example.mealpicker.data.PlannedMeal

@Composable
fun GroceryOverviewScreen(
    meals: MutableList<PlannedMeal>,
    addingMeal: Boolean,
    stopAdding: () -> Unit,
) {
    Box {

        if (addingMeal) {
            var name by remember {
                mutableStateOf("flower")
            }

            UpdateMeal(
                name,
                onChangeName = { name = it },
                onAdd = {
                    meals.add(PlannedMeal(name, "Monday", listOf(Ingredient.getOne())))
                    //addingMeal1 = false
                    stopAdding()
                },

                )
        } else {
            Column {
                AllPlannedMeals(meals)
                IngredientList()
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
@Composable
fun IngredientList() {
    val ingredient = Ingredient.getOne()

    Column(modifier = Modifier.fillMaxWidth()) {
        IngredientItem(name = ingredient.name, instruction = ingredient.instruction)
    }
}