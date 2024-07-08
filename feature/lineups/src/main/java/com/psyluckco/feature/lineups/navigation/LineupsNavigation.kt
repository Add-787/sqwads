/**
 * Created by developer on 02-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.feature.lineups.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.psyluckco.feature.lineups.ui.LineupsRoute

const val LINEUPS_ROUTE = "lineups"

fun NavController.navigateToLineups(navOptions: NavOptions) = navigate(LINEUPS_ROUTE, navOptions)

fun NavGraphBuilder.lineupsScreen(
    onLineupClicked: (String) -> Unit,
) {
    composable(route = LINEUPS_ROUTE) {
        LineupsRoute(
            onLineupClicked = onLineupClicked
        )
    }
}