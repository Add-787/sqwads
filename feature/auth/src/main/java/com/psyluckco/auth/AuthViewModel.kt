/**
 * Created by developer on 04-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psyluckco.data.models.User
import com.psyluckco.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    val userRepository: UserRepository
) : ViewModel() {

    val userUiState: StateFlow<AuthUiState> = userRepository
        .user
        .filter { user -> user.id.isNotEmpty() }
        .map<User,AuthUiState>(AuthUiState::Authenticated)
        .onStart { emit(AuthUiState.Unauthenticated) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = AuthUiState.Unauthenticated
        )

    private val loginUiState = MutableStateFlow<AuthUiState>(AuthUiState.Unauthenticated)

    val authUiState = merge(userUiState,loginUiState)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = AuthUiState.Unauthenticated
        )

    fun login(username : String, password : String) {
        viewModelScope.launch {
            loginUiState.emit(AuthUiState.Loading("Logging in"))
            userRepository.login(username,password)
        }
    }

}

sealed interface AuthUiState {
    data class Loading(val message : String) : AuthUiState
    data class Authenticated(val user : User) : AuthUiState
    data object Unauthenticated : AuthUiState
}