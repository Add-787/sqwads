/**
 * Created by developer on 03-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.psyluckco.auth.navigation.loginScreen
import com.psyluckco.data.models.User
import com.psyluckco.design.components.SqwadsButton
import com.psyluckco.design.components.SqwadsLoadingDialog
import com.psyluckco.design.components.SqwadsTextField
import com.psyluckco.design.icons.SqwadsIcons
import com.psyluckco.design.theme.SqwadsTheme
import org.w3c.dom.Text
import timber.log.Timber

@Composable
internal fun LoginRoute(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = hiltViewModel()
) {

    val authUiState by viewModel.authUiState.collectAsState()

    LoginScreen(
        authUiState = authUiState,
        modifier = modifier
    )

}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
@Composable
internal fun LoginScreen(
    authUiState: AuthUiState,
    modifier: Modifier = Modifier,
    navigateToLineups: () -> Unit = {}
) {

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(authUiState is AuthUiState.Loading) {
            SqwadsLoadingDialog(loadingMsg = authUiState.message)
        } else {

            Column(
                modifier = modifier
                    .height(575.dp)
                    .padding(horizontal = 49.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceAround
            ) {

                var email by remember { mutableStateOf("") }

                var password by remember { mutableStateOf("") }

                Column {
                    Text(
                        "Login",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(11.dp))
                    Text(
                        "Login with your email and password",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Light,
                        color = MaterialTheme.colorScheme.secondary
                    )
                }
                


                SqwadsTextField(
                    value = email,
                    onValueChange = { it -> email = it },
                    trailingIcon = { Icon(imageVector = SqwadsIcons.Email, contentDescription = null)}
                )

                SqwadsTextField(
                    value = password,
                    label = "Password",
                    onValueChange = { it -> password = it },
                    placeholder = "Enter your password",
                    trailingIcon = { Icon(imageVector = SqwadsIcons.Password, contentDescription = null)}
                )

                SqwadsButton(
                    modifier = modifier
                        .height(47.dp)
                        .fillMaxWidth(),
                    text = "Login"
                )

                Row(
                    modifier = modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    val annotatedText = buildAnnotatedString {
                        append("Don't have an account?\n")

                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colorScheme.primary,
                                textDecoration = TextDecoration.Underline
                            )
                        ) {
                            append("Sign up")
                        }

                    }

                    ClickableText(
                        text = annotatedText,
                        style = MaterialTheme.typography.labelMedium.copy(textAlign = TextAlign.Center)
                    ) {
                        Timber.i("Navigate to sign up page")
                    }

                }


            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    SqwadsTheme {
        LoginScreen(
            authUiState = AuthUiState.Success(user = User(id = "436", username = "user1"))
        )
    }
}