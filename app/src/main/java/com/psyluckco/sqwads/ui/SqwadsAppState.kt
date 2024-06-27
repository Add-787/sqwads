/**
 * Created by developer on 27-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.sqwads.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.CoroutineScope

@Stable
class SqwadsAppState(
    val navController : NavHostController,
    coroutineScope: CoroutineScope
) {

    val currentDestination : NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination



}