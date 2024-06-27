/**
 * Created by developer on 27-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.profile.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val PROFILE_ROUTE = "profile"
fun NavController.navigateToProfile(navOptions : NavOptions)  = navigate(PROFILE_ROUTE, navOptions)
fun NavGraphBuilder.profileScreen() {
    composable(route = PROFILE_ROUTE) {

    }
}