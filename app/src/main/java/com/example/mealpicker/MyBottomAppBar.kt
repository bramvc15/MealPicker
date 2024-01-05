package com.example.mealpicker

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun MyBottomAppBar(
    onHome: () -> Unit,
    onScheduler: () -> Unit,
    onTotalList: () -> Unit,
    onProfile: () -> Unit,
) {
    BottomAppBar(
        containerColor = MaterialTheme.colorScheme.primaryContainer,
        contentColor = MaterialTheme.colorScheme.primary,
        actions = {
            IconButton(onClick = onHome) {
                Icon(Icons.Filled.Home, contentDescription = "Localized description")
            }
            IconButton(onClick = onScheduler) {
                Icon(Icons.Filled.DateRange, contentDescription = "Localized description")
            }
            IconButton(onClick = onTotalList) {
                Icon(
                    Icons.Filled.List,
                    contentDescription = "Localized description",
                )
            }
            IconButton(onClick = onProfile) {
                Icon(Icons.Filled.Person, contentDescription = "Localized description")
            }
        },
    )
}
