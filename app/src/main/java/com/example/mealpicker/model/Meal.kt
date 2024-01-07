package com.example.mealpicker.model

import com.example.mealpicker.network.APIMeal
import kotlinx.serialization.Serializable


data class Meal (
    //var id: Int, kan dat dit nog moet
    var name: String = "",
    var instruction: String = "",
    //var day: String = "",
    //var ingredients: List<Ingredient> = listOf(),
)
