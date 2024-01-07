package com.example.mealpicker.navigation

import androidx.annotation.StringRes
import com.example.mealpicker.R

enum class Destination (@StringRes val title: Int){
    Home(title = R.string.home_info_title),
    Calendar(title = R.string.calendar_info_title),
    GroceryOverview(title = R.string.grocery_overview_info_title),
    Profile(title = R.string.profile_info_title),
}
