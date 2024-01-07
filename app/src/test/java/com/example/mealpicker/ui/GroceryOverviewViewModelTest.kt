@file:OptIn(ExperimentalCoroutinesApi::class, ExperimentalCoroutinesApi::class)

package com.example.mealpicker.ui

import com.example.mealpicker.fake.FakeApiMealsRepository
import com.example.mealpicker.model.Meal
import com.example.mealpicker.ui.GroceryScreen.GroceryOverviewViewModel
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class GroceryOverviewViewModelTest {
    lateinit var viewModel: GroceryOverviewViewModel

    @get:Rule
    val testDispatcher = TestDispatchersRule()

    @Before
    fun initializeViewModel()  {
        viewModel = GroceryOverviewViewModel(FakeApiMealsRepository())
    }

    @Test
    fun viewModelStartsWithEmptyNewMealName() {
        assertEquals("", viewModel.uiState.value.newMealName)
    }

    @Test
    fun viewModelStartsWithEmptyNewMealDay() {
        assertEquals("", viewModel.uiState.value.newDescription)
    }


    @Test
    fun `can set meal name`()  {
        viewModel.setNewMealName("test")
        assertEquals("test", viewModel.uiState.value.newMealName)
    }

    @Test
    fun `can set meal day`()  {
        viewModel.setNewMealDay("test")
        assertEquals("test", viewModel.uiState.value.newDescription)
    }

    @Test
    fun `name gets cleared when saved`()  {
        viewModel.setNewMealName("test")
        viewModel.addIngredient()
        assertEquals("", viewModel.uiState.value.newMealName)
    }

    @Test
    fun `day gets cleared when saved`()  {
        viewModel.setNewMealDay("test")
        viewModel.addIngredient()
        assertEquals("", viewModel.uiState.value.newDescription)
    }
}

class TestDispatchersRule
    @OptIn(ExperimentalCoroutinesApi::class)
    constructor(
        private val testDispatcher: TestDispatcher = UnconfinedTestDispatcher(),
    ) : TestWatcher() {
        override fun starting(description: Description?) {
            super.starting(description)
            Dispatchers.setMain(testDispatcher)
        }

        override fun finished(description: Description?) {
            super.finished(description)
            Dispatchers.resetMain()
        }
    }
