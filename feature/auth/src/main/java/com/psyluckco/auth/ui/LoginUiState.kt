/**
 * Created by developer on 04-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth.ui

import com.psyluckco.data.models.User
import java.lang.Exception

sealed interface LoginUiState {
    data object Loading : LoginUiState
    data class Success(val user: User) : LoginUiState
    data class Failure(val error: Exception) : LoginUiState
}