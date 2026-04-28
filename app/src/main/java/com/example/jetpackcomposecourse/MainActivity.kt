package com.example.jetpackcomposecourse

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecourse.components.elements.MaterialButton
import com.example.jetpackcomposecourse.components.elements.MaterialNavigationBar
import com.example.jetpackcomposecourse.components.elements.MaterialTopBar
import com.example.jetpackcomposecourse.components.elements.NavigationOption
import com.example.jetpackcomposecourse.components.elements.Spacer24
import com.example.jetpackcomposecourse.components.layouts.MyListColumn
import com.example.jetpackcomposecourse.screens.login.LoginScreen
import com.example.jetpackcomposecourse.ui.theme.JetpackComposeCourseTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCourseTheme {
                val context = LocalContext.current
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Column(
                                modifier = Modifier.padding(horizontal = 16.dp)
                            ) {
                                Text("Drawer title", modifier = Modifier.padding(16.dp))
                                HorizontalDivider()
                                NavigationDrawerItem(
                                    label = { Text(text = "Drawer Item") },
                                    selected = false,
                                    onClick = { /*TODO*/ }
                                )
                            }
                        }
                    }
                ) {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            MaterialTopBar(
                                title = stringResource(R.string.app_name),
                                onNavigationClick = {
                                    // TODO: Implement show drawer logic
                                    scope.launch {
                                        drawerState.apply {
                                            if (isClosed) open() else close()
                                        }
                                    }
                                }
                            )
                        }
                    ) { innerPadding ->
                        LoginScreen(modifier = Modifier.fillMaxSize().padding(innerPadding))
                    }
                }
            }
        }
    }
}
