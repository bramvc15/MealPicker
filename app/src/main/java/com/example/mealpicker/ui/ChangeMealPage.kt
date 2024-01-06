package com.example.mealpicker.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun UpdateMeal(
    day: String,
    name: String,
    onChangeName: (String) -> Unit,
    onChangeDay: (String) -> Unit,
    onAdd: () -> Unit,
) {
    Column {
        CreateDropdown(day, onChangeDay)

        TextField(label = { Text("Name: ") }, value = name, onValueChange = onChangeName)

        Button(onClick = onAdd) {
            Text("Change meal")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateDropdown(day:String, onChangeDay: (String) -> Unit) {

    val days =
        listOf(
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday",
        )
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf(day) }

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
        ) {
            OutlinedTextField(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                readOnly = true,
                value = selectedItem,
                onValueChange = onChangeDay,
                label = { Text("Select a day") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                colors =
                    OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = MaterialTheme.colorScheme.primary,
                        unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                    ),
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                days.forEach { day ->
                    DropdownMenuItem(
                        text = { Text(day) },
                        onClick = {
                            selectedItem = day
                            expanded = false
                            onChangeDay(day)
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }

        }
    }
}
