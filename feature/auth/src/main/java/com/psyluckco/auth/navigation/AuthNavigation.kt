/**
 * Created by developer on 03-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.navigation
import timber.log.Timber

const val AUTH_ROUTE = "auth"

fun NavController.navigateToAuth(navOptions: NavOptions?) = navigate(AUTH_ROUTE, navOptions)

fun NavGraphBuilder.authScreens(
    navController : NavHostController
) {

    navigation(startDestination = LOGIN_ROUTE, route = AUTH_ROUTE) {
        loginScreen(
            navigateToSignup = { navController.navigateToSignup() },
            navigateToLineups = { }
        )
        signUpScreen()
    }

}