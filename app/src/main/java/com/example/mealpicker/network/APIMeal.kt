package com.example.mealpicker.network

import com.example.mealpicker.model.Meal
import kotlinx.serialization.Serializable
import retrofit2.Call

@Serializable
data class APIMeal(
    val strMeal: String,
    val strDrinkAlternate: String,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strTags: String,
    val strYoutube: String,
    val Ingredients: List<String>,
    val measurments: List<String>,
    val strSource: String,
    val strImageSource: String,
    val strCreativeCommonsConfirmed: String,
    val dateModified: String,
)
un Call<APIMeal>.asDomainObjectCall(): Call<Meal> {
    return object : Call<Meal> {
        override fun execute(): Response<Meal> {
            return Response.success(execute().body()?.asDomainObject() ?: Meal())
        }

        override fun enqueue(callback: Callback<Meal>) {
            // For simplicity, you can just call execute in this example
            val response = execute()
            callback.onResponse(this, response)
        }

        // Other methods similar to the previous example...
    }



