package com.example.mealpicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mealpicker.ui.MealPickerApp
import com.example.mealpicker.ui.theme.MealPickerTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealPickerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    MealPickerApp()
                }
            }
        }
    }
}


@Preview
@Composable
fun ScaffoldExamplePreview() {
    MealPickerApp()
}




