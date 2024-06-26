/**
 * Created by developer on 26-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.design.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.psyluckco.design.theme.SqwadsTheme

@Composable
fun SqwadsButton(
    modifier : Modifier = Modifier,
    onClick: () -> Unit = { } ,
    enabled: Boolean = true
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled
    ) {
        Text("Click")
    }

}

@Preview
@Composable
fun SqwadsButtonPreview() {
    SqwadsTheme {
        SqwadsButton()
    }
}





