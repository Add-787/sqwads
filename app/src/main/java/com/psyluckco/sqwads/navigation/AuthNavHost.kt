/**
 * Created by developer on 09-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.sqwads.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.psyluckco.auth.navigation.AUTH_ROUTE
import com.psyluckco.auth.navigation.authScreens
import com.psyluckco.sqwads.ui.SqwadsAppState

@Composable
fun AuthNavHost(
    appState: SqwadsAppState,
    modifier: Modifier,
    startDestination: String = AUTH_ROUTE
) {

    val navController  = appState.navController

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination) {
        authScreens(
            navController = navController
        )
    }

}