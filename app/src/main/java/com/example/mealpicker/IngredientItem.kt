package com.example.mealpicker

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    name: String = "",
    instruction: String = "",
) {
    var checked by rememberSaveable { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier =
        modifier
            .height(IntrinsicSize.Min)
            .fillMaxWidth(),
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(
                name,
                fontSize = 26.sp,
                lineHeight = 40.sp,
            )
            Text(
                instruction,
                fontSize = 14.sp,
                lineHeight = 20.sp,
            )
        }
        Checkbox(checked = checked, onCheckedChange = { checked = !checked })
    }
}