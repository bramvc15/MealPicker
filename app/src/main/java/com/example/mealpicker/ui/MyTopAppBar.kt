package com.example.mealpicker.ui

import android.graphics.drawable.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MyTopAppBar(
    canNavigateBack: Boolean,
    navigateUp: () -> Unit,
    currentScreenTitle : Int,
) {
    TopAppBar(
        colors =
            TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
        title = {

            Text(stringResource(id = currentScreenTitle), color = MaterialTheme.colorScheme.onPrimaryContainer)
        },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "navigate back",
                    )
                }
            }
        },
    )
}
