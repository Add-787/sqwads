/**
 * Created by developer on 27-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.sqwads.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.psyluckco.design.components.SqwadsNavigationBar
import com.psyluckco.design.components.SqwadsNavigationBarItem
import com.psyluckco.design.icons.SqwadsIcons
import com.psyluckco.sqwads.navigation.SqwadsNavHost
import com.psyluckco.sqwads.navigation.TopLevelDestination

@Composable
fun SqwadsApp(
    appState : SqwadsAppState,
    modifier: Modifier = Modifier
) {

    val currentDestination = appState.currentDestination

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
            SqwadsNavHost(
                appState = appState,
                onShowSnackbar = { _, _ -> false },
                modifier = modifier.padding(it)
            )

    }

}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false