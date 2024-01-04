package com.example.mealpicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.smallTopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mealpicker.data.Ingrediant
import com.example.mealpicker.data.PlannedMeal
import com.example.mealpicker.ui.theme.MealPickerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealPickerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    listOfGroceryPage()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun listOfGroceryPage() {
    var addingMeal by remember {
        mutableStateOf(false)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors =
                    smallTopAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                title = {
                    Text("Top app bar")
                },
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier =
                        Modifier
                            .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { addingMeal = true }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
    ) { innerPadding ->
        Column(
            modifier =
                Modifier
                    .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            val meals =
                remember {
                    val list = PlannedMeal.getAll().toMutableList()

                    list.toMutableStateList()
                }
            if (addingMeal) {
                var name by remember {
                    mutableStateOf("flower")
                }
                updateMeal(
                    name,
                    onChangeName = { name = it },
                    onAdd={
                        meals.add(PlannedMeal(name, "Monday", listOf(Ingrediant.getOne())))
                        addingMeal = false
                    }
                )
            } else {
                AllPlannedMeals(meals)
                IngrediantList()
            }
        }
    }
}

@Composable
fun AllPlannedMeals(meals: List<PlannedMeal>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "All planned meals",
            fontSize = 26.sp,
            lineHeight = 40.sp,
        )
        for (meal in meals) {
            MealItem(name = meal.name, day = meal.day)
        }

        Text(
            text = "Grocery list",
            fontSize = 26.sp,
            lineHeight = 20.sp,
            color = MaterialTheme.colorScheme.primary,
        )
    }
}

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
            text = "$name",
            // center vertically
            modifier =
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            fontSize = 18.sp,
        )
    }
}

@Preview
@Composable
fun ScaffoldExamplePreview() {
    listOfGroceryPage()
}

@Composable
fun IngrediantList() {
    val ingrediant = Ingrediant.getOne()

    Column(modifier = Modifier.fillMaxWidth()) {
        IngrediantItem(name = ingrediant.name, instruction = ingrediant.instruction)
    }
}

@Preview
@Composable
fun IngrediantListPreview() {
    MealPickerTheme {
        IngrediantList()
    }
}

@Composable
fun IngrediantItem(
    name: String = "",
    instruction: String = "",
    modifier: Modifier = Modifier,
) {
    var checked by remember{mutableStateOf(false)}
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
                "$name",
                fontSize = 26.sp,
                lineHeight = 40.sp,
            )
            Text(
                "$instruction",
                fontSize = 14.sp,
                lineHeight = 20.sp,
            )
        }

        Checkbox(checked = checked, onCheckedChange = {checked = !checked})
    }
}

@Preview
@Composable
fun MealPreview() {
    MealPickerTheme {
        IngrediantItem()
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealPickerTheme {
        Greeting("Android")
    }
}

// les2 toevoegen

@Composable
fun updateMeal(
    name: String,
    onChangeName: (String) -> Unit,
    onAdd: () -> Unit,
) {
    createDropdown()

    TextField(label = { Text("Name: ")},value = "name", onValueChange = onChangeName)
    Button(onClick = onAdd) {
        Text("Change meal")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun createDropdown() {
    var days =
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
    var selectedItem by remember { mutableStateOf("Select an item") }
    Box(modifier = Modifier.padding(16.dp)) {
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
                onValueChange = {},
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
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                    )
                }
            }
        }
    }
}
