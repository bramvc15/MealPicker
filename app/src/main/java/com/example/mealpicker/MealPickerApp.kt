package com.example.mealpicker

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import data.PlannedMeal

enum class Destination {
    Home,
    Calendar,
    GroceryOverview,
    Profile,
}

@Composable
fun MealPickerApp() {
    var addingMeal by remember {
        mutableStateOf(false)
    }
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    Scaffold(
        topBar = {
            MyTopAppBar(
                {
                    val isStartDestination = currentBackStackEntry?.destination?.route == Destination.Home.name
                    if (!isStartDestination) {
                        IconButton(onClick = {
                            navController.popBackStack()
                        }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                },
                when(currentBackStackEntry?.destination?.route){
                    Destination.Home.name -> R.string.home_info_title
                    Destination.Calendar.name -> R.string.calendar_info_title
                    Destination.GroceryOverview.name -> R.string.grocery_overview_info_title
                    Destination.Profile.name -> R.string.profile_info_title
                    else -> R.string.app_title
                }
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
                val list = PlannedMeal.getAll().toMutableList()

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
