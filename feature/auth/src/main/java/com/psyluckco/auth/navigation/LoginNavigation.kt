/**
 * Created by developer on 03-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.psyluckco.auth.LoginRoute

const val LOGIN_ROUTE = "login"

fun NavGraphBuilder.loginScreen() {

    composable(route = LOGIN_ROUTE) {
        LoginRoute()
    }
}