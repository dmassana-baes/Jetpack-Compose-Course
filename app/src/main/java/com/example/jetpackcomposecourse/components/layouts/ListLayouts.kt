package com.example.jetpackcomposecourse.components.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyListColumn(modifier: Modifier = Modifier) {
    val superItems = rememberSaveable {
        mutableStateListOf(
            SuperItemState("Leche"),
            SuperItemState("Pan"),
            SuperItemState("Huevos"),
            SuperItemState("Queso"),
            SuperItemState("Frutas"),
            SuperItemState("Verduras"),
            SuperItemState("Carne"),
            SuperItemState("Pescado"),
            SuperItemState("Cereal"),
            SuperItemState("Yogur")
        )
    }

    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                text = "Mi listado de super",
                style = MaterialTheme.typography.headlineMedium
            )
        }

        items(superItems) { item ->
            SuperItem(item) { checked ->
                val index = superItems.indexOf(item)
                if (index != -1) {
                    superItems[index] = item.copy(isChecked = checked)
                }
            }
        }

        item {
            Button(onClick = {
                superItems.add(SuperItemState(value = "Coca Cola"))
            }) {
                Text(text = "Agregar nuevo item")
            }
        }
    }
}

@Composable
fun SuperItem(
    item: SuperItemState,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = item.isChecked, onCheckedChange = { onCheckedChange(it) })
        Text(
            text = item.value,
            textDecoration = if (item.isChecked) TextDecoration.LineThrough else TextDecoration.None
        )
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
private fun MyListColumnPreview() {
    MaterialTheme {
        MyListColumn(modifier = Modifier.fillMaxSize())
    }
}

// Cambiamos a Boolean inmutable y usamos copy() para actualizar la lista
data class SuperItemState(
    val value: String,
    val isChecked: Boolean = false
)
