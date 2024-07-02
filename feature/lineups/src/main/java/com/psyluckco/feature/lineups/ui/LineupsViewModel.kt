/**
 * Created by developer on 25-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.feature.lineups.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@HiltViewModel
class LineupsViewModel @Inject constructor() : ViewModel() {

    private val _lineupsUiState = MutableStateFlow(LineupsUiState.Loading)
    val lineupsUiState: StateFlow<LineupsUiState> = _lineupsUiState


}