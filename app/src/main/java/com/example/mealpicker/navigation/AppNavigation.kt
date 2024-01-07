package com.example.mealpicker.navigation

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mealpicker.ui.GroceryScreen.GroceryOverviewScreen
import com.example.mealpicker.ui.GroceryScreen.GroceryOverviewViewModel

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    addingMeal: Boolean = false,
) {
    val GroceryViewModel: GroceryOverviewViewModel = viewModel(factory = GroceryOverviewViewModel.Factory)
    NavHost(
        navController = navController,
        startDestination = Destination.Home.name,
        modifier = modifier,
    ) {
        Log.d("MealPickerApp", "NavHost initialized")
        composable(Destination.Home.name) {
            Text("Home page")
        }
        composable(Destination.Calendar.name) {
            Text("Calendar overview")
        }
        composable(Destination.GroceryOverview.name) {
            GroceryOverviewScreen(
                addingMeal =addingMeal,
                viewModel = GroceryViewModel,
                stopAdding = { /*addingMeal = false*/ },
            )
        }
        composable(Destination.Profile.name) {
            Text("Profile page")
        }
    }
}
