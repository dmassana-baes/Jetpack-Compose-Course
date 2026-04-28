package com.example.jetpackcomposecourse.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.jetpackcomposecourse.R
import com.example.jetpackcomposecourse.components.elements.MaterialTopBar
import com.example.jetpackcomposecourse.screens.home.HomeScreen
import com.example.jetpackcomposecourse.screens.login.LoginScreen

@Composable
fun App() {
    val navController = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MaterialTopBar(
                title = stringResource(R.string.app_name),
                onNavigationClick = {
                    navController.navigateUp()
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = Login
        ) {
            composable<Login> {
                LoginScreen(modifier = Modifier.fillMaxSize(), onLoginSuccess = { email ->
                    navController.navigate(Home(email)) {
                        popUpTo(Login) {
                            inclusive = true
                        }
                    }
                })
            }
            composable<Home> { backStackEntry ->
                val args = backStackEntry.toRoute<Home>()
                HomeScreen(email = args.email)
            }
        }
    }
}