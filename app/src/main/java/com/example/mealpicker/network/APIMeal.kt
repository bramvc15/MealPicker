package com.example.mealpicker.network

import android.util.Log
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
    val ingredients: List<String>,
    val measurements: List<String>,
    val strSource: String,
    val strImageSource: String,
    val strCreativeCommonsConfirmed: String,
    val dateModified: String,
)
fun List<APIMeal>.asDomainObjects(): List<Meal> {
    //Log.d("APIMeal", "Retrofit initialized")
    return this.map { it.asDomainObject() }
}

fun APIMeal.asDomainObject(): Meal {
    return Meal(name = strMeal, instruction = strMealThumb)
}




