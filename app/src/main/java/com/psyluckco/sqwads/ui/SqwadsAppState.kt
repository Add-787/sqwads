/**
 * Created by developer on 27-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.sqwads.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.psyluckco.auctions.navigation.AUCTIONS_ROUTE
import com.psyluckco.auctions.navigation.navigateToAuctions
import com.psyluckco.auth.navigation.navigateToAuth
import com.psyluckco.data.models.User
import com.psyluckco.data.repository.UserRepository
import com.psyluckco.feature.lineups.navigation.navigateToLineups
import com.psyluckco.profile.navigation.navigateToProfile
import com.psyluckco.sqwads.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberSqwadsAppState(
    userRepository: UserRepository,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
) : SqwadsAppState {

    return remember(
        userRepository, navController, coroutineScope
    ) {
        SqwadsAppState(userRepository, navController, coroutineScope)
    }


}
@Stable
class SqwadsAppState(
    val userRepository: UserRepository,
    val navController : NavHostController,
    coroutineScope: CoroutineScope
) {

    val currentDestination : NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when(currentDestination?.route) {
            AUCTIONS_ROUTE -> TopLevelDestination.AUCTIONS
            else -> null
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        when(topLevelDestination) {
            TopLevelDestination.LINEUPS -> navController.navigateToLineups(topLevelNavOptions)
            TopLevelDestination.AUCTIONS -> navController.navigateToAuctions(topLevelNavOptions)
            TopLevelDestination.PROFILE -> navController.navigateToProfile(topLevelNavOptions)
        }
    }

    val isLoggedIn : Boolean
        get() = userRepository.currentUser.id.isNotEmpty()

    fun navigateToAuth() = navController.navigateToAuth(navOptions = null)

}