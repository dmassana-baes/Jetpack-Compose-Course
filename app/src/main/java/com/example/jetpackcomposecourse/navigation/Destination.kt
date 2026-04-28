package com.example.jetpackcomposecourse.navigation

import kotlinx.serialization.Serializable

@Serializable
data object Login

@Serializable
data class Home(
    val email: String
)
