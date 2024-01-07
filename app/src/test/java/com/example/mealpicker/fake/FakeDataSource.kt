package com.example.mealpicker.fake

import com.example.mealpicker.network.APIMeal
/*data class APIMeal(
    val strMeal: String,
    val strDrinkAlternate: String,
    val strCategory: String,
    val strArea: String,
    val strInstructions: String,
    val strMealThumb: String,
    val strTags: String,
    val strYoutube: String,
    val Ingredients: List<String>,
    val measurements: List<String>,
    val strSource: String,
    val strImageSource: String,
    val strCreativeCommonsConfirmed: String,
    val dateModified: String,
)*/
object FakeDataSource {
    const val strMealOne = "Chicken"
    const val strMealTwo = "Beef"
    const val strDrinkAlternateOne = "Cook it"
    const val strDrinkAlternateTwo = "Cook it again"
    const val strCategoryOne = "Chicken"
    const val strCategoryTwo = "Beef"
    const val strAreaOne = "Chicken"
    const val strAreaTwo = "Beef"
    const val strInstructionsOne = "Cook it"
    const val strInstructionsTwo = "Cook it again"
    const val strMealThumbOne = "Chicken"
    const val strMealThumbTwo = "Beef"
    const val strTagsOne = "Chicken"
    const val strTagsTwo = "Beef"
    const val strYoutubeOne = "Chicken"
    const val strYoutubeTwo = "Beef"
    val IngredientsOne = listOf("Chicken")
    val IngredientsTwo = listOf("Beef")
    val measurementsOne = listOf("Chicken")
    val measurementsTwo = listOf("Beef")
    val strSourceOne = "Chicken"
    val strSourceTwo = "Beef"
    val strImageSourceOne = "Chicken"
    val strImageSourceTwo = "Beef"
    val strCreativeCommonsConfirmedOne = "Chicken"
    val strCreativeCommonsConfirmedTwo = "Beef"
    val dateModifiedOne = "Chicken"
    val dateModifiedTwo = "Beef"







    val meals = listOf(
        APIMeal(
            strMeal = strMealOne,
            strDrinkAlternate = strDrinkAlternateOne,
            strCategory = strCategoryOne,
            strArea = strAreaOne,
            strInstructions = strInstructionsOne,
            strMealThumb = strMealThumbOne,
            strTags = strTagsOne,
            strYoutube = strYoutubeOne,
            Ingredients = IngredientsOne,
            measurements = measurementsOne,
            strSource = strSourceOne,
            strImageSource = strImageSourceOne,
            strCreativeCommonsConfirmed = strCreativeCommonsConfirmedOne,
            dateModified = dateModifiedOne,
        ),
        APIMeal(
            strMeal = strMealTwo,
            strDrinkAlternate = strDrinkAlternateTwo,
            strCategory = strCategoryTwo,
            strArea = strAreaTwo,
            strInstructions = strInstructionsTwo,
            strMealThumb = strMealThumbTwo,
            strTags = strTagsTwo,
            strYoutube = strYoutubeTwo,
            Ingredients = IngredientsTwo,
            measurements = measurementsTwo,
            strSource = strSourceTwo,
            strImageSource = strImageSourceTwo,
            strCreativeCommonsConfirmed = strCreativeCommonsConfirmedTwo,
            dateModified = dateModifiedTwo,
        )
    )
}