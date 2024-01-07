package com.example.mealpicker.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.ui.graphics.vector.ImageVector
data class NavItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)

val listOfNavItems : List<NavItem> = listOf(
    NavItem(
        label = "Home",
        icon = Icons.Default.Create,
        route = Destination.Home.name
    ),
    NavItem(
        label = "Calendar",
        icon = Icons.Outlined.DateRange,
        route = Destination.Calendar.name
    ),
    NavItem(
        label = "Weekly ingredients",
        icon = Icons.Filled.DateRange,
        route = Destination.GroceryOverview.name
    ),
    NavItem(
        label = "Profile",
        icon = Icons.Filled.DateRange,
        route = Destination.Profile.name
    ),

)