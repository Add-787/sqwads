/**
 * Created by developer on 25-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.feature.lineups.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.psyluckco.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class LineupsViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    // val lineupsUiState: StateFlow<LineupsUiState>

    fun getData() {
        userRepository.user.map {
            user ->
        }
    }





}