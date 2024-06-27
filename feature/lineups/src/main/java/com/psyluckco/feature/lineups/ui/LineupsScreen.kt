/**
 * Created by developer on 25-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.feature.lineups.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.psyluckco.feature.lineups.R

@Composable
internal fun LineupsRoute(
    onLineupClick : () -> Unit = {},
    modifier : Modifier = Modifier,
    viewModel: LineupsViewModel = hiltViewModel()
) {
    LineupsScreen(
        lineupsUiState = LineupsUiState.Loading
    )
}
@Composable
internal fun LineupsScreen(
    lineupsUiState: LineupsUiState,
    modifier: Modifier = Modifier
) {

    if(lineupsUiState is LineupsUiState.Loading) {

    }

}


@Preview
@Composable
internal fun LineupsLoadingScreenPreview(
    lineupsUiState: LineupsUiState = LineupsUiState.Loading
) {


}