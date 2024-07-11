/**
 * Created by developer on 04-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.psyluckco.auth.SignupRoute

const val SIGNUP_ROUTE = "signup"

fun NavGraphBuilder.signUpScreen() {
    composable(route = SIGNUP_ROUTE) {
        SignupRoute()
    }
}