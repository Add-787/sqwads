/**
 * Created by developer on 11-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
internal fun SignupRoute(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = hiltViewModel(),
    navigateToLineups: () -> Unit = { }
) {

    val authUiState by viewModel.userUiState.collectAsState()

    SignupScreen(authUiState = authUiState)

}

@Composable
fun SignupScreen(
    authUiState: AuthUiState,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize()
    ) {

    }

}