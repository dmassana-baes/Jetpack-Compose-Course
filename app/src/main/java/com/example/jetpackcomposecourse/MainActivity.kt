package com.example.jetpackcomposecourse

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.components.elements.MaterialButton
import com.example.jetpackcomposecourse.components.elements.MaterialNavigationBar
import com.example.jetpackcomposecourse.components.elements.NavigationOption
import com.example.jetpackcomposecourse.components.elements.Spacer24
import com.example.jetpackcomposecourse.components.layouts.MyListColumn
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourseTheme {
                val context = LocalContext.current
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        FloatingActionButton(onClick = {}) {
                            Icon(painter = painterResource(R.drawable.ic_add), contentDescription = null)
                        }
                    },
                    bottomBar = {
                        MaterialNavigationBar(
                            options = NavigationOption.entries.toList(),
                            onClickOption = { option ->
                                Toast.makeText(
                                    context,
                                    "Clicked on ${option.name}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )
                    }
                ) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        MaterialButton(
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp),
                            text = stringResource(R.string.continue_btn_label),
                            shape = RoundedCornerShape(8.dp),
                            containerColor = MaterialTheme.colorScheme.secondary,
                            onClick = {
                                println("Continue button clicked")
                            }
                        )
                        Spacer24()
                        MaterialButton(
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                            onClick = {
                                println("Next button clicked")
                            }
                        )
                    }
                }
            }
        }
    }
}
