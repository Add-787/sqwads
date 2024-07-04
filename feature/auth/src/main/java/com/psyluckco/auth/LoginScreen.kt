/**
 * Created by developer on 03-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.psyluckco.auth.navigation.loginScreen
import com.psyluckco.design.theme.SqwadsTheme

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier
) {
    LoginScreen(
        modifier = modifier
    )

}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
@Composable
internal fun LoginScreen(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "This is Login Screen",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    SqwadsTheme {
        LoginScreen()
    }
}