package com.example.mealpicker.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mealpicker.model.Meal

@Entity(tableName = "meals")
data class DbMeal(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = "",
    var instruction: String = "",
    var image: String = "",
    var day: String = "",
)

fun Meal.asDbMeal() = DbMeal(name = name, instruction = instruction)

fun DbMeal.asDomainMeal() = Meal(name = name, instruction = instruction)

fun List<DbMeal>.asDomainMeals() = map { it.asDomainMeal() }