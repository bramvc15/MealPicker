package com.example.mealpicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.example.compose.MealPickerTheme
import com.example.mealpicker.ui.MealPickerApp
import com.example.mealpicker.ui.utils.MealPickerNavigationType

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealPickerTheme {
                Surface {
                    val windowSize = calculateWindowSizeClass(activity = this)
                    when (windowSize.widthSizeClass) {
                        WindowWidthSizeClass.Compact -> {
                            MealPickerApp(navigationType = MealPickerNavigationType.BOTTOM_NAVIGATION)
                        }
                        WindowWidthSizeClass.Medium -> {
                            MealPickerApp(navigationType = MealPickerNavigationType.NAVIGATION_RAIL)
                        }
                        WindowWidthSizeClass.Expanded -> {
                            MealPickerApp(navigationType = MealPickerNavigationType.PERMANENT_NAVIGATION_DRAWER)
                        }
                        else -> {
                            MealPickerApp(navigationType = MealPickerNavigationType.BOTTOM_NAVIGATION)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ScaffoldExamplePreview() {
    MealPickerApp(MealPickerNavigationType.BOTTOM_NAVIGATION)
}
