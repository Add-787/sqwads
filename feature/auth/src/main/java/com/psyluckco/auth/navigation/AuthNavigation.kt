/**
 * Created by developer on 03-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auth.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

const val AUTH_ROUTE = "auth"

fun NavGraphBuilder.authScreens() {

    navigation(startDestination = LOGIN_ROUTE, route = AUTH_ROUTE) {
        loginScreen()
    }

}