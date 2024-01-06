package com.example.mealpicker.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun MealItem(
    modifier: Modifier = Modifier,
    name: String = "",
    day: String = "",
) {
    ElevatedCard()
    {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth(),
        ) {
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
}