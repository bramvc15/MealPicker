package com.example.mealpicker.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: DbMeal)
    @Query("SELECT * FROM meals ORDER BY id DESC")
    fun getAllItems(): Flow<List<DbMeal>>

    @Query("SELECT * FROM meals where id = :id")
    fun getItem(id: Int): Flow<DbMeal>
}