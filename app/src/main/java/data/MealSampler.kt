package data

import com.example.mealpicker.model.Ingredient
import com.example.mealpicker.model.Meal

data class MealSampler(val name: String, val day: String, val ingredients: List<IngredientSampler>) {
    companion object plannedMealSampler {
        val samplePlannedMeals =
            listOf(
                Meal("meal 1", "Monday", listOf(Ingredient( "ingredient 1", "instruction 1"))),
                Meal("meal 2", "Tuesday", listOf(Ingredient("ingredient 2", "instruction 2"))),
                Meal("meal 3", "Wednesday", listOf(Ingredient("ingredient 3", "instruction 3"))),
                Meal("meal 4", "Thursday", listOf(Ingredient("ingredient 4", "instruction 4"))),
                Meal("meal 5", "Friday", listOf(Ingredient("ingredient 5", "instruction 5"))),
                Meal("meal 6", "Saturday", listOf(Ingredient("ingredient 6", "instruction 6"))),
                Meal("meal 7", "Sunday", listOf(Ingredient("ingredient 7", "instruction 7"))),
            )
        val getAll: () -> List<Meal> = {
            val list = mutableListOf<Meal>()
            for(item in samplePlannedMeals){
                list.add(Meal(item.name, item.day, item.ingredients))
            }
            list

        }

    }
}
