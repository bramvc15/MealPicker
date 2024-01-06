package com.example.mealpicker.ui.GroceryScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.mealpicker.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateMeal(
    day: String,
    name: String,
    onChangeName: (String) -> Unit,
    onChangeDay: (String) -> Unit,
    onAdd: () -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier =
                modifier
                    .padding(24.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier.padding(24.dp),
            ) {
                Text(stringResource(R.string.update_a_meal), style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(16.dp))
                CreateDropdown(day, onChangeDay, modifier)
                Spacer(modifier = Modifier.height(16.dp))
                TextField(label = { Text("Name: ") }, value = name, onValueChange = onChangeName)
                Spacer(modifier = Modifier.height(25.dp))
                TextButton(
                    onClick = onAdd,
                    modifier = Modifier.align(Alignment.End),
                ) {
                    Text("Change meal")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateDropdown(
    day: String,
    onChangeDay: (String) -> Unit,
    modifier: Modifier,
) {
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
                modifier
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

@Preview
@Composable
fun UpdateMealPreview() {
    UpdateMeal(
        day = "Monday",
        name = "Spaghetti",
        onChangeName = {},
        onChangeDay = {},
        onAdd = {},
        onDismissRequest = {},
    )
}
