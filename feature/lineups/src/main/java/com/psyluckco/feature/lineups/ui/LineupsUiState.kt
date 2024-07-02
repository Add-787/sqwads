package com.psyluckco.feature.lineups.ui

sealed interface LineupsUiState {
    object Loading : LineupsUiState
    data class Success(val lineups : List<String>) : LineupsUiState
}