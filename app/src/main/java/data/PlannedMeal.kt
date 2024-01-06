package data

data class PlannedMeal(val name: String, val day: String, val ingredients: List<Ingredient>) {
    companion object plannedMealSampler {
        val samplePlannedMeals =
            listOf(
                PlannedMeal("meal 1", "Monday", listOf(Ingredient.getOne(), Ingredient.getOne())),
                PlannedMeal("meal 2", "Tuesday", listOf(Ingredient.getOne(), Ingredient.getOne())),
                PlannedMeal("meal 3", "Wednesday", listOf(Ingredient.getOne(), Ingredient.getOne())),
                PlannedMeal("meal 4", "Thursday", listOf(Ingredient.getOne(), Ingredient.getOne())),
                PlannedMeal("meal 5", "Friday", listOf(Ingredient.getOne(), Ingredient.getOne())),
                PlannedMeal("meal 6", "Saturday", listOf(Ingredient.getOne(), Ingredient.getOne())),
                PlannedMeal("meal 7", "Sunday", listOf(Ingredient.getOne(), Ingredient.getOne())),
            )
        val getAll: () -> List<PlannedMeal> = {
            samplePlannedMeals
        }

    }
}
