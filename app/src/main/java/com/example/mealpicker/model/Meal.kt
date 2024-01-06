package com.example.mealpicker.model

import data.IngredientSampler

data class Meal (
    var name: String = "",
    var day: String = "",
    var ingredients: List<Ingredient> = listOf(),
)