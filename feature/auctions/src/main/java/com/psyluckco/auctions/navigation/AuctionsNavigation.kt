/**
 * Created by developer on 27-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auctions.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.psyluckco.auctions.AuctionsRoute

const val AUCTIONS_ROUTE = "auctions"

fun NavController.navigateToAuctions(navOptions: NavOptions) = navigate(AUCTIONS_ROUTE, navOptions)

fun NavGraphBuilder.auctionsScreen(
    onRoomClicked: (String) -> Unit,
    onShowSnackbar: suspend (String, String?) -> Boolean,
) {
    composable(route = AUCTIONS_ROUTE) {
        AuctionsRoute()
    }
}