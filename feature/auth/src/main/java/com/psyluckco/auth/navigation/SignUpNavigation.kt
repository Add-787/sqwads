/**
 * Created by developer on 04-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.psyluckco.auth.SignupRoute

const val SIGNUP_ROUTE = "signup"

fun NavController.navigateToSignup() = navigate(SIGNUP_ROUTE)

fun NavGraphBuilder.signUpScreen() {
    composable(route = SIGNUP_ROUTE) {
        SignupRoute()
    }
}