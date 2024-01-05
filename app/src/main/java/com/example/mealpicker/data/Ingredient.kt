package com.example.mealpicker.data

import kotlin.random.Random

data class Ingredient(val name: String, val instruction: String = "") {
    companion object ingrediantSampler {
        val sampleIngredients =
            listOf(
                Ingredient("ingrediant 1", "instructions"),
                Ingredient("ingrediant 2", "instructions"),
                Ingredient("ingrediant 3", "instructions"),
                Ingredient("ingrediant 4", "instructions"),
                Ingredient("ingrediant 5", "instructions"),
                Ingredient("ingrediant 6", "instructions"),
                Ingredient("ingrediant 7", "instructions"),
                Ingredient("ingrediant 8", "instructions"),
                Ingredient("ingrediant 9", "instructions"),
                Ingredient("ingrediant 10", "instructions"),
                Ingredient("ingrediant 11", "instructions"),
                Ingredient("ingrediant 12", "instructions"),
                Ingredient("ingrediant 13", "instructions"),
                Ingredient("ingrediant 14", "instructions"),
                Ingredient("ingrediant 15", "instructions"),
                Ingredient("ingrediant 16", "instructions"),
                Ingredient("ingrediant 17", "instructions"),
                Ingredient("ingrediant 18", "instructions"),
                Ingredient("ingrediant 19", "instructions"),
                Ingredient("ingrediant 20", "instructions"),
                Ingredient("ingrediant 21", "instructions"),
                Ingredient("ingrediant 22", "instructions"),
                Ingredient("ingrediant 23", "instructions"),
                Ingredient("ingrediant 24", "instructions"),
                Ingredient("ingrediant 25", "instructions"),
                Ingredient("ingrediant 26", "instructions"),
                Ingredient("ingrediant 27", "instructions"),
                Ingredient("ingrediant 28", "instructions"),
                Ingredient("ingrediant 29", "instructions"),
                Ingredient("ingrediant 30", "instructions"),
                Ingredient("ingrediant 31", "instructions"),
                Ingredient("ingrediant 32", "instructions"),
                Ingredient("ingrediant 33", "instructions"),
                Ingredient("ingrediant 34", "instructions"),
                Ingredient("ingrediant 35", "instructions"),
            )
        val getOne: () -> Ingredient = {
            Ingredient(
                sampleIngredients[Random.nextInt(0, sampleIngredients.size)].name,
                sampleIngredients[Random.nextInt(0, sampleIngredients.size)].instruction,
            )
        }
    }
}
