package com.example.mealpicker.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mealpicker.R
import com.example.mealpicker.ui.GroceryScreen.GroceryOverviewScreen
import com.example.mealpicker.ui.GroceryScreen.GroceryOverviewViewModel
import data.MealSampler

enum class Destination (@StringRes val title: Int){
    Home(title = R.string.home_info_title),
    Calendar(title = R.string.calendar_info_title),
    GroceryOverview(title = R.string.grocery_overview_info_title),
    Profile(title = R.string.profile_info_title),
}

@Composable
//navController in parameter voor te kunnen testen anders zal bij zelf 1 aanmaken
fun MealPickerApp(navController: NavHostController = rememberNavController()) {
    var addingMeal by rememberSaveable {
        mutableStateOf(false)
    }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreenTitle = Destination.valueOf(currentBackStackEntry?.destination?.route ?: Destination.Home.name).title
    val navigateUp: () -> Unit = {
        navController.popBackStack(
            Destination.Home.name,
            inclusive = false
        )
    }
    val canNavigateBack = navController.previousBackStackEntry != null

    Scaffold(
        topBar = {

            MyTopAppBar(
                canNavigateBack = canNavigateBack,
                navigateUp = navigateUp,

                currentScreenTitle = currentScreenTitle,
            )
        },
        bottomBar = {
            MyBottomAppBar(
                { navController.popBackStack(Destination.Home.name, false) },
                { navController.navigate(Destination.Calendar.name) },
                { navController.navigate(Destination.GroceryOverview.name) },
                { navController.navigate(Destination.Profile.name) },
            )
        },
        floatingActionButton = {
            when (currentBackStackEntry?.destination?.route) {
                Destination.GroceryOverview.name -> {
                    FloatingActionButton(onClick = { addingMeal = true }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }
                Destination.Calendar.name -> {
                    FloatingActionButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }
            }
        },
    ) { innerPadding ->
        val meals =
            remember {
                val list = MealSampler.getAll().toMutableList()

                list.toMutableStateList()
            }
        NavHost(
            navController = navController,
            startDestination = Destination.Home.name,
            Modifier.padding(innerPadding),
        ) {

            composable(Destination.Home.name) {
                val viewMode: GroceryOverviewViewModel = viewModel()
                Text("Home page")
            }
            composable(Destination.Calendar.name) {
                val viewMode: GroceryOverviewViewModel = viewModel()
                Text("Calendar overview")
            }
            composable(Destination.GroceryOverview.name) {
                val viewMode: GroceryOverviewViewModel = viewModel()
                GroceryOverviewScreen(addingMeal, { addingMeal = false })
            }
            composable(Destination.Profile.name) {
                val viewMode: GroceryOverviewViewModel = viewModel()
                Text("Profile page")
            }
        }
    }
}
