package com.example.jetpackcomposecourse.components.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.R

@Composable
fun MaterialButton(
    modifier: Modifier = Modifier,
    text: String = stringResource(R.string.next_btn_label),
    shape: Shape = CircleShape,
    containerColor: Color = MaterialTheme.colorScheme.primary,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor
        )
    ) {
        Text(text = text)
    }
}

@Composable
fun MaterialIconButton() {
    FilledIconButton(onClick = {}) {
        Icon(
            painter = painterResource(R.drawable.ic_add),
            contentDescription = null
        )
    }
}

@Composable
fun MaterialLoader() {
    CircularProgressIndicator(modifier = Modifier.size(16.dp))
}

@Composable
fun MaterialNavigationBar(
    options: List<NavigationOption>,
    onClickOption: (NavigationOption) -> Unit
) {
    NavigationBar {
        var selectedOption by rememberSaveable {
            mutableStateOf(NavigationOption.HOME)
        }
        options.forEach { option ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(option.icon),
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = stringResource(option.label))
                },
                selected = selectedOption == option,
                onClick = {
                    selectedOption = option
                    onClickOption(option)
                }
            )
        }
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun MaterialButtonPreview() {
    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            MaterialButton()
            MaterialIconButton()
            MaterialLoader()
        }
    }
}