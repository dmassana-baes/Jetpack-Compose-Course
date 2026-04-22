package com.example.jetpackcomposecourse.components.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(10) { index ->
            val color = if (index % 2 == 0) Color.Red else Color.Green
            Box(modifier = Modifier
                .width(100.dp)
                .height(100.dp)
                .background(color))
        }
    }
}

@Preview(showBackground = false, device = "id:pixel_5")
@Composable
private fun LayoutsPreview() {
    MaterialTheme {
        MyColumn(modifier = Modifier.fillMaxSize())
    }
}