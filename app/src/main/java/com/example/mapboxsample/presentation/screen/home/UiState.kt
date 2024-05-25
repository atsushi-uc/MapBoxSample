package com.example.mapboxsample.presentation.screen.home

data class UiState (
    var isBackHandlingEnabled: Boolean = true,
    var isLoading: Boolean = false,
    var error: String? = null,
)