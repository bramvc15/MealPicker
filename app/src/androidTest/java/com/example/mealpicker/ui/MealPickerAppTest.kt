package com.example.mealpicker.ui

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import androidx.test.platform.app.InstrumentationRegistry
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MealPickerAppTest {
    // Is deel van de UI test
    @get:Rule
    val composeTestRule = createComposeRule()
    //lateinit wil zeggen dat de variabele niet meteen geinitialiseerd moet worden
    lateinit var navController: TestNavHostController

    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MealPickerApp(navController)

        }
    }

    @Test
    fun ShowNavigationSchedulerButton() {
        composeTestRule
            .onNodeWithContentDescription("navigate to scheduler page")
            .assertIsDisplayed()
            .assertIsEnabled()
    }

    //Kijken of de startpagina getoond wordt
    @Test
    fun `startappshowsstartscreen`() {
        composeTestRule
            .onNodeWithText(getResourceString(Destination.Home.title))
            .assertIsDisplayed()
    }

    @Test
    fun ShowNavigationGroceryButton() {
        composeTestRule
            .onNodeWithContentDescription("navigate to total grocery list page")
            .assertIsDisplayed()
            .assertIsEnabled()
    }
    @Test
    fun `clickOnGroceryNavigationButton`() {
        composeTestRule
            .onNodeWithContentDescription("navigate to total grocery list page")
            .performClick()
        assertEquals(Destination.GroceryOverview.name, navController.currentBackStackEntry?.destination?.route)

    }
    @Test
    fun `clickOnCalendarNavigationButton`() {
        composeTestRule
            .onNodeWithContentDescription("navigate to scheduler page")
            .performClick()
        assertEquals(Destination.Calendar.name, navController.currentBackStackEntry?.destination?.route)

    }
    @Test
    fun `clickOnProfileNavigationButton`() {
        composeTestRule
            .onNodeWithContentDescription("navigate to profile page")
            .performClick()
        assertEquals(Destination.Profile.name, navController.currentBackStackEntry?.destination?.route)

    }

    @Test
    fun ShowNavigationProfileButton() {
        composeTestRule
            .onNodeWithContentDescription("navigate to profile page")
            .assertIsDisplayed()
            .assertIsEnabled()
    }

    private fun getResourceString(@StringRes key: Int): String{
        val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
        return context.resources.getString(key)
    }
}
