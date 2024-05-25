package com.example.mapboxsample.presentation.screen.home

sealed interface UiEvent {
    data class NavigateToSomewhere(val arg: String): UiEvent
}