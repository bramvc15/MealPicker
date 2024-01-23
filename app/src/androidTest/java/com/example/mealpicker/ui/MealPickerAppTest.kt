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
import com.example.mealpicker.navigation.Destination
import com.example.mealpicker.ui.utils.MealPickerNavigationType
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
    //<string name="home_info_title">Home</string>
 //   <string name="calendar_info_title">Calendar</string>
//    <string name="grocery_overview_info_title">Grocery Overview</string>
  //  <string name="profile_info_title">Profile</string>
    @Before
    fun setUp() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            MealPickerApp(MealPickerNavigationType.PERMANENT_NAVIGATION_DRAWER, navController)

        }
    }

    @Test
    fun ShowNavigationSchedulerButton() {
        composeTestRule
            .onNodeWithContentDescription("Calendar")
            .assertIsDisplayed()
            .assertIsEnabled()
    }

    @Test
    fun ShowNavigationGroceryButton() {
        composeTestRule
            .onNodeWithContentDescription("Grocery Overview")
            .assertIsDisplayed()
            .assertIsEnabled()
    }

    @Test
    fun `clickOnGroceryNavigationButton`() {
        composeTestRule
            .onNodeWithContentDescription("Grocery Overview")
            .performClick()
        assertEquals(Destination.GroceryOverview.name, navController.currentBackStackEntry?.destination?.route)
    }

    @Test
    fun `clickOnCalendarNavigationButton`() {
        composeTestRule
            .onNodeWithContentDescription("Calendar")
            .performClick()
        assertEquals(Destination.Calendar.name, navController.currentBackStackEntry?.destination?.route)
    }

    @Test
    fun `clickOnProfileNavigationButton`() {
        composeTestRule
            .onNodeWithContentDescription("Profile")
            .performClick()
        assertEquals(Destination.Profile.name, navController.currentBackStackEntry?.destination?.route)
    }

    @Test
    fun ShowNavigationProfileButton() {
        composeTestRule
            .onNodeWithContentDescription("Profile")
            .assertIsDisplayed()
            .assertIsEnabled()
    }


    private fun getResourceString(@StringRes key: Int): String{
        val context: Context = InstrumentationRegistry.getInstrumentation().targetContext
        return context.resources.getString(key)
    }
}
