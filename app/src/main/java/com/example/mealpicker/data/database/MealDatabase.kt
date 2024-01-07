package com.example.mealpicker.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities = [DbMeal::class], version=1)
abstract class MealDatabase: RoomDatabase() {
    abstract fun mealDao(): MealDao
}