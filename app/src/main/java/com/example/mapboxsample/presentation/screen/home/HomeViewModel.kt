package com.example.mapboxsample.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {
    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvents: MutableStateFlow<List<UiEvent>> = MutableStateFlow(emptyList())
    val uiEvents = _uiEvents.asStateFlow()
    fun consume(target: UiEvent) {
        _uiEvents.update { e -> e.filterNot { it == target } }
    }

    fun dismissErrorDialog() {
        _uiState.update { it.copy(error = null) }
    }

    fun navigateToPhotoDetail(arg: String) {
        _uiEvents.update { it + UiEvent.NavigateToSomewhere(arg) }
    }

    override fun onCleared() {
        super.onCleared()
        // ViewModelが死ぬタイミングで全てのコルーチンはキャンセルする
        viewModelScope.cancel()
    }

}