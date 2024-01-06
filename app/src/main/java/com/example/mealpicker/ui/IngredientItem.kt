package com.example.mealpicker.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
    ElevatedCard(
        modifier = modifier.padding(16.dp,4.dp),
    ){
        var checked by rememberSaveable { mutableStateOf(false) }
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier =
            modifier
                .animateContentSize (
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .height(IntrinsicSize.Min)
                .fillMaxWidth(),
        ) {
            var expanded by remember { mutableStateOf(false) }
            Column(modifier = Modifier.padding(8.dp)) {

                Row (
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Checkbox(checked = checked, onCheckedChange = { checked = !checked })
                    Text(
                        name,
                        fontSize = 26.sp,
                        lineHeight = 40.sp,
                    )
                }

                if (expanded){
                    Text(
                        instruction,
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                    )
                }

            }

            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = { expanded = !expanded}) {
                Icon(
                    imageVector= if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                    contentDescription= "expand",
                )
            }
        }
    }
}
