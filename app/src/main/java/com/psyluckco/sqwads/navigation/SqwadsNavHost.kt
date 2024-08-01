/**
 * Created by developer on 27-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.sqwads.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.psyluckco.auctions.navigation.AUCTIONS_ROUTE
import com.psyluckco.auctions.navigation.auctionsScreen
import com.psyluckco.auth.navigation.authScreens
import com.psyluckco.design.components.SqwadsNavigationBar
import com.psyluckco.design.components.SqwadsNavigationBarItem
import com.psyluckco.design.icons.SqwadsIcons
import com.psyluckco.feature.lineups.navigation.LINEUPS_ROUTE
import com.psyluckco.feature.lineups.navigation.lineupsScreen
import com.psyluckco.profile.navigation.profileScreen
import com.psyluckco.sqwads.ui.SqwadsAppState

@Composable
fun SqwadsNavHost(
    appState: SqwadsAppState,
    onShowSnackbar: suspend (String,String?) -> Boolean,
    modifier: Modifier,
    startDestination: String
) {

    val currentDestination = appState.currentDestination
    val navController = appState.navController

    Scaffold(
        modifier = modifier,
        bottomBar = {
            SqwadsNavigationBar {
                appState.topLevelDestinations.forEach {
                        topLevelDestination ->
                    val selected = currentDestination.isTopLevelDestinationInHierarchy(topLevelDestination)

                    SqwadsNavigationBarItem(
                        onClick = { appState.navigateToTopLevelDestination(topLevelDestination) },
                        label = { Text(topLevelDestination.name, style = MaterialTheme.typography.labelSmall) },
                        icon = { Icon(SqwadsIcons.PlaceHolder, contentDescription = null) },
                        selected = selected
                    )
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            modifier = modifier.padding(it),
            startDestination = startDestination
        ) {
            lineupsScreen(onLineupClicked = {})
            auctionsScreen(onRoomClicked = {},onShowSnackbar = onShowSnackbar)
            profileScreen()
            authScreens(navController)
        }

    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false