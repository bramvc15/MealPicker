package com.example.mealpicker.ui

import com.example.mealpicker.model.Meal
import com.example.mealpicker.ui.GroceryScreen.GroceryOverviewViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Test

class GroceryOverviewViewModelTest {
    private val viewModel = GroceryOverviewViewModel()

    @Test
    fun viewModelStartsWithEmptyNewMealName() {
        assertEquals("", viewModel.uiState.value.newMealName)
    }

    @Test
    fun viewModelStartsWithEmptyNewMealDay() {
        assertEquals("", viewModel.uiState.value.newMealDay)
    }
    @Test
    fun viewModelStartsWithEmptyCurrentMealList() {
        assertEquals(listOf<Meal>(), viewModel.uiState.value.currentMealList)
    }

    @Test
    fun `can set meal name` (){
        viewModel.setNewMealName("test")
        assertEquals("test", viewModel.uiState.value.newMealName)
    }

    @Test
    fun `can set meal day` (){
        viewModel.setNewMealDay("test")
        assertEquals("test", viewModel.uiState.value.newMealDay)
    }

    @Test
    fun `name gets cleared when saved`(){
        viewModel.setNewMealName("test")
        viewModel.addIngredient()
        assertEquals("", viewModel.uiState.value.newMealName)
    }

    @Test
    fun `day gets cleared when saved`(){
        viewModel.setNewMealDay("test")
        viewModel.addIngredient()
        assertEquals("", viewModel.uiState.value.newMealDay)
    }


}