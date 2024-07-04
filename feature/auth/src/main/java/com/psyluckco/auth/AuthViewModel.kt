/**
 * Created by developer on 04-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.psyluckco.auth.ui.LoginUiState
import com.psyluckco.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    fun login(username : String, password : String) : Flow<LoginUiState> = flow {
        viewModelScope.launch {
            emit(LoginUiState.Loading)
            val userStatus = userRepository.login(username,password)



        }
    }





}