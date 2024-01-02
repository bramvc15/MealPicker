package com.example.mealpicker.data

import kotlin.random.Random

data class PlannedMeal(val name: String, val day: String, val ingrediants: List<Ingrediant>) {
    companion object plannedMealSampler {
        val samplePlannedMeals =
            listOf(
                PlannedMeal("meal 1", "Monday", listOf(Ingrediant.getOne(), Ingrediant.getOne())),
                PlannedMeal("meal 2", "Tuesday", listOf(Ingrediant.getOne(), Ingrediant.getOne())),
                PlannedMeal("meal 3", "Wednesday", listOf(Ingrediant.getOne(), Ingrediant.getOne())),
                PlannedMeal("meal 4", "Thursday", listOf(Ingrediant.getOne(), Ingrediant.getOne())),
                PlannedMeal("meal 5", "Friday", listOf(Ingrediant.getOne(), Ingrediant.getOne())),
                PlannedMeal("meal 6", "Saturday", listOf(Ingrediant.getOne(), Ingrediant.getOne())),
                PlannedMeal("meal 7", "Sunday", listOf(Ingrediant.getOne(), Ingrediant.getOne())),
            )
        val getAll: () -> List<PlannedMeal> = {
            samplePlannedMeals
        }

    }
}
