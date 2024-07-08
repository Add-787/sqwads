/**
 * Created by developer on 25-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.feature.lineups.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.psyluckco.design.theme.SqwadsTheme
import com.psyluckco.feature.lineups.R

@Composable
internal fun LineupsRoute(
    onLineupClicked : (String) -> Unit = {},
    modifier : Modifier = Modifier,
    viewModel: LineupsViewModel = hiltViewModel()
) {

    val lineupsState by viewModel.lineupsUiState.collectAsState()

    LineupsScreen(
        lineupsUiState = lineupsState,
        modifier = modifier
    )
}
@Composable
internal fun LineupsScreen(
    lineupsUiState: LineupsUiState,
    modifier: Modifier = Modifier
) {

   Column(
       modifier = modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Text(
           "This is Lineups Screen",
           style = MaterialTheme.typography.headlineMedium,
           fontWeight = FontWeight.Bold
       )
   }

}


@Preview(showBackground = true)
@Composable
internal fun LineupsScreenPreview(
    lineupsUiState: LineupsUiState = LineupsUiState.Loading
) {

    SqwadsTheme {
        LineupsScreen(lineupsUiState = LineupsUiState.Success(emptyList()))
    }

}