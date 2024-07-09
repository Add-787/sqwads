/**
 * Created by developer on 04-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth

import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psyluckco.data.models.User
import com.psyluckco.data.repository.UserRepository
import com.psyluckco.login.R
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    val authUiState: StateFlow<AuthUiState> = userRepository
        .user.map<User,AuthUiState>(AuthUiState::Success)
        .onStart { emit(AuthUiState.Success(User(username = "guest"))) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = AuthUiState.Success(User(username = "guest"))
        )

    fun login(username : String, password : String) : Flow<AuthUiState> = flow {
        viewModelScope.launch {
            emit(AuthUiState.Loading("Logging in"))
            userRepository.login(username,password)
        }
    }

}

sealed interface AuthUiState {
    data class Loading(val message : String) : AuthUiState
    data class Success(val user : User) : AuthUiState
    data class Failure(val error : Exception) : AuthUiState
}