package com.example.mealpicker.data

import kotlin.random.Random

data class Ingrediant(val name: String, val instruction: String = "") {
    companion object ingrediantSampler {
        val sampleIngrediants =
            listOf(
                Ingrediant("ingrediant 1", "instructions"),
                Ingrediant("ingrediant 2", "instructions"),
                Ingrediant("ingrediant 3", "instructions"),
                Ingrediant("ingrediant 4", "instructions"),
                Ingrediant("ingrediant 5", "instructions"),
                Ingrediant("ingrediant 6", "instructions"),
                Ingrediant("ingrediant 7", "instructions"),
                Ingrediant("ingrediant 8", "instructions"),
                Ingrediant("ingrediant 9", "instructions"),
                Ingrediant("ingrediant 10", "instructions"),
                Ingrediant("ingrediant 11", "instructions"),
                Ingrediant("ingrediant 12", "instructions"),
                Ingrediant("ingrediant 13", "instructions"),
                Ingrediant("ingrediant 14", "instructions"),
                Ingrediant("ingrediant 15", "instructions"),
                Ingrediant("ingrediant 16", "instructions"),
                Ingrediant("ingrediant 17", "instructions"),
                Ingrediant("ingrediant 18", "instructions"),
                Ingrediant("ingrediant 19", "instructions"),
                Ingrediant("ingrediant 20", "instructions"),
                Ingrediant("ingrediant 21", "instructions"),
                Ingrediant("ingrediant 22", "instructions"),
                Ingrediant("ingrediant 23", "instructions"),
                Ingrediant("ingrediant 24", "instructions"),
                Ingrediant("ingrediant 25", "instructions"),
                Ingrediant("ingrediant 26", "instructions"),
                Ingrediant("ingrediant 27", "instructions"),
                Ingrediant("ingrediant 28", "instructions"),
                Ingrediant("ingrediant 29", "instructions"),
                Ingrediant("ingrediant 30", "instructions"),
                Ingrediant("ingrediant 31", "instructions"),
                Ingrediant("ingrediant 32", "instructions"),
                Ingrediant("ingrediant 33", "instructions"),
                Ingrediant("ingrediant 34", "instructions"),
                Ingrediant("ingrediant 35", "instructions"),
            )
        val getOne: () -> Ingrediant = {
            Ingrediant(
                sampleIngrediants[Random.nextInt(0, sampleIngrediants.size)].name,
                sampleIngrediants[Random.nextInt(0, sampleIngrediants.size)].instruction,
            )
        }
    }
}
