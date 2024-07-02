/**
 * Created by developer on 27-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.auctions

import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.psyluckco.design.theme.SqwadsTheme

@Composable
internal fun AuctionsRoute(
    modifier: Modifier = Modifier,
    viewModel: AuctionsViewModel = hiltViewModel()
) {

    AuctionsScreen(
        modifier = modifier
    )

}

@VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
@Composable
internal fun AuctionsScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "This is Auctions Screen",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
            )
    }
}

@Preview(showBackground = true)
@Composable
private fun AuctionScreenPreview() {
    SqwadsTheme {
        AuctionsScreen()
    }
}

