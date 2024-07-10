/**
 * Created by developer on 09-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.sqwads.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.psyluckco.auth.navigation.authScreens

@Composable
fun AuthNavHost(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "") {
        authScreens()
    }
    
}