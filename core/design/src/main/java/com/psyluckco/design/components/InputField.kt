/**
 * Created by developer on 08-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.design.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.psyluckco.design.theme.SqwadsTheme

@Composable
fun SqwadsTextField(
    value : String,
    onValueChange : (String) -> Unit,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = "E-mail")}
    )
    
}

@Preview(showBackground = true)
@Composable
private fun EmailFieldPreview() {
    SqwadsTheme {
        SqwadsTextField(
            value = "E-mail",
            onValueChange = {},
            visualTransformation = PasswordVisualTransformation()
        )
    }

}

@Preview(showBackground = true)
@Composable
private fun PasswordFieldPreview() {
    SqwadsTheme {
        SqwadsTextField(
            value = "Password",
            onValueChange = {},
            visualTransformation = PasswordVisualTransformation()
        )
    }

}

