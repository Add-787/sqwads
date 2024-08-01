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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.psyluckco.auth.navigation.AUTH_ROUTE
import com.psyluckco.design.components.SqwadsNavigationBar
import com.psyluckco.design.components.SqwadsNavigationBarItem
import com.psyluckco.design.icons.SqwadsIcons
import com.psyluckco.feature.lineups.navigation.LINEUPS_ROUTE
import com.psyluckco.sqwads.navigation.AuthNavHost
import com.psyluckco.sqwads.navigation.SqwadsNavHost
import com.psyluckco.sqwads.navigation.TopLevelDestination

@Composable
fun SqwadsApp(
    appState : SqwadsAppState,
    modifier: Modifier = Modifier,
) {

    val loggedIn by appState.isLoggedIn.collectAsState()

    if(!loggedIn) {
        AuthNavHost(appState = appState, modifier = modifier)
    } else {
        SqwadsNavHost(
            appState = appState,
            onShowSnackbar = { _,_ -> false},
            modifier = modifier,
            startDestination = LINEUPS_ROUTE
        )
    }

}
