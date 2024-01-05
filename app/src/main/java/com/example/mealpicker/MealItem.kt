package com.example.mealpicker

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MealItem(
    name: String = "",
    day: String = "",
) {
    Row {
        Text(
            text = "$day: ",
            fontSize = 26.sp,
            lineHeight = 40.sp,
        )
        Text(
            text = name,
            // center vertically
            modifier =
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            fontSize = 18.sp,
        )
    }
}