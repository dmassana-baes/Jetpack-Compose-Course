package com.example.jetpackcomposecourse.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEmailChange(value: String) {
        _uiState.update { state ->
            state.copy(email = value)
        }
    }

    fun onPasswordChange(value: String) {
        _uiState.update { state ->
            state.copy(password = value)
        }
    }

    fun onTogglePasswordVisibility() {
        _uiState.update { previousState ->
            previousState.copy(isPasswordVisible = !previousState.isPasswordVisible)
        }
    }

    fun onLoadingChange(isLoading: Boolean) {
        _uiState.update { previousState ->
            previousState.copy(isLoading = isLoading)
        }
    }

    fun onLoginClick() {
        viewModelScope.launch {
            onLoadingChange(isLoading = true)
            delay(3000) // simula llamada a red
            onLoadingChange(isLoading = false)
        }
    }
}
