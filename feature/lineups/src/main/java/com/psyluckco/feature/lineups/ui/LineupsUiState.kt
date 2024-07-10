package com.psyluckco.feature.lineups.ui

import com.psyluckco.data.models.User

sealed interface LineupsUiState {
    object Loading : LineupsUiState
    data class Success(
        val lineups : List<String>
    ) : LineupsUiState
}