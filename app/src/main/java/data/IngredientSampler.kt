package data

import com.example.mealpicker.model.Ingredient
import kotlin.random.Random

data class IngredientSampler(val name: String, val instruction: String = "") {
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
            )
        val getOne: () -> IngredientSampler = {
            IngredientSampler(
                sampleIngredients[Random.nextInt(0, sampleIngredients.size)].name,
                sampleIngredients[Random.nextInt(0, sampleIngredients.size)].instruction,
            )
        }
        val getAll: () -> List<Ingredient> = {
            val list = mutableListOf<Ingredient>()
            for(item in sampleIngredients){
                list.add(Ingredient(item.name, item.instruction))
            }
            list
        }
    }
}
