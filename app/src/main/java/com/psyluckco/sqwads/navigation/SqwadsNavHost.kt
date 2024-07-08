/**
 * Created by developer on 27-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.sqwads.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.psyluckco.auctions.navigation.AUCTIONS_ROUTE
import com.psyluckco.auctions.navigation.auctionsScreen
import com.psyluckco.feature.lineups.navigation.LINEUPS_ROUTE
import com.psyluckco.feature.lineups.navigation.lineupsScreen
import com.psyluckco.profile.navigation.profileScreen
import com.psyluckco.sqwads.ui.SqwadsAppState

@Composable
fun SqwadsNavHost(
    appState: SqwadsAppState,
    onShowSnackbar: suspend (String,String?) -> Boolean,
    modifier: Modifier,
    startDestination: String = LINEUPS_ROUTE
) {

    val navController = appState.navController

    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {

        lineupsScreen(onLineupClicked = {})
        auctionsScreen(onRoomClicked = {},onShowSnackbar = onShowSnackbar)
        profileScreen()

    }

}