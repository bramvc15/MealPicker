package com.example.mealpicker.ui

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mealpicker.R
import com.example.mealpicker.navigation.AppNavigation
import com.example.mealpicker.navigation.Destination
import com.example.mealpicker.ui.components.MealPickerBottomNavigation
import com.example.mealpicker.ui.components.MealPickerNavigationRail
import com.example.mealpicker.ui.components.NavigationDrawerContent
import com.example.mealpicker.ui.utils.MealPickerNavigationType

// navController in parameter voor te kunnen testen anders zal bij zelf 1 aanmaken
@Composable
fun MealPickerApp(
    navigationType: MealPickerNavigationType,
    navController: NavHostController = rememberNavController(),
) {
    var addingMeal by rememberSaveable {
        mutableStateOf(false)
    }

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreenTitle = Destination.valueOf(currentBackStackEntry?.destination?.route ?: Destination.Home.name).title
    val navigateUp: () -> Unit = {
        navController.popBackStack(
            Destination.Home.name,
            inclusive = false,
        )
    }
    val canNavigateBack = navController.previousBackStackEntry != null
    when {
        navigationType == MealPickerNavigationType.PERMANENT_NAVIGATION_DRAWER -> {
            PermanentNavigationDrawer(drawerContent = {
                PermanentDrawerSheet(Modifier.width(dimensionResource(R.dimen.drawer_width))) {
                    NavigationDrawerContent(
                        selectedDestination = navController.currentDestination,
                        navController = navController,
                        modifier = Modifier.fillMaxWidth(),
                    )
                }
            }) {
                Scaffold(
                    topBar = {
                        MyTopAppBar(
                            canNavigateBack = canNavigateBack,
                            navigateUp = navigateUp,
                            currentScreenTitle = currentScreenTitle,
                        )
                    },
                    floatingActionButton = {
                        when (currentBackStackEntry?.destination?.route) {
                            Destination.GroceryOverview.name -> {
                                FloatingActionButton(onClick = { addingMeal }) {
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
                    AppNavigation(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                    )
                }
            }
        }

        navigationType == MealPickerNavigationType.BOTTOM_NAVIGATION -> {
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
                }

            ) { innerPadding ->

                AppNavigation(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController,

                    )
            }
        }

        navigationType == MealPickerNavigationType.NAVIGATION_RAIL -> {
            Log.d("VisionApp", "VisionNavigationType.NAVIGATION_RAIL")
            Row {
                AnimatedVisibility(visible = true) {
                    NavigationRail {
                        MealPickerNavigationRail(
                            selectedDestination = navController.currentDestination,
                            navController = navController,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }
                Scaffold(
                    containerColor = Color.Transparent,
                ) { innerPadding ->
                    AppNavigation(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    } 
}
