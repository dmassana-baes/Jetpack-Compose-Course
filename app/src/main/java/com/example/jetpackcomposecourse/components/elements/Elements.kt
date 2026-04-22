package com.example.jetpackcomposecourse.components.elements

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.R

@Composable
fun MyText() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.hello_world_title),
        style = MaterialTheme.typography.displayLarge,
        color = Color.Blue,
        textAlign = TextAlign.Center
    )
}

// Custom spacers
@Composable
fun MySpacer(modifier: Modifier = Modifier) {
    Spacer(modifier)
}

@Composable
fun ColumnScope.Spacer1f() = Spacer(modifier = Modifier.weight(1f))

@Composable
fun RowScope.Spacer1f() = Spacer(modifier = Modifier.weight(1f))

@Composable
fun ColumnScope.Spacer24() = Spacer(modifier = Modifier.height(24.dp))

// Images and icons
@Composable
fun MyImage(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center) {
        Image(
            modifier = modifier,
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null
        )
        MyIcon()
    }
}

@Composable
fun MyIcon() {
    Box(modifier = Modifier.clip(CircleShape).background(Color.Blue)) {
        Icon(
            painter = painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview(showSystemUi = false, showBackground = true)
@Composable
private fun MyElementsPreview() {
    MaterialTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            MyText()
            Spacer24()
            MyText()
            Spacer24()
            MyImage(modifier = Modifier.size(200.dp))
        }
    }
}