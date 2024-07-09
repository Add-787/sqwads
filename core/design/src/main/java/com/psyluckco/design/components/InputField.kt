/**
 * Created by developer on 08-07-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.design.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.psyluckco.design.icons.SqwadsIcons
import com.psyluckco.design.theme.SqwadsTheme

@Composable
fun SqwadsTextField(
    value : String,
    onValueChange : (String) -> Unit,
    modifier : Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholder: String = "Enter your email",
    trailingIcon: @Composable() (() -> Unit)? = { Icon(imageVector = SqwadsIcons.PlaceHolder, contentDescription = null)},
    label: String = "Email"
) {

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(text = label)
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier.fillMaxWidth(),
            placeholder = { Text(text = placeholder, color = MaterialTheme.colorScheme.secondary) },
            trailingIcon = trailingIcon,
            shape = RoundedCornerShape(9.dp),
            visualTransformation = visualTransformation,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = MaterialTheme.colorScheme.background,
                unfocusedIndicatorColor = SqwadsTextFieldDefaults.textFieldUnfocusedColor().copy(alpha = 0.5f),
                focusedIndicatorColor = SqwadsTextFieldDefaults.textFieldFocusedColor(),
                unfocusedTrailingIconColor = SqwadsTextFieldDefaults.textFieldUnfocusedColor(),
                focusedTrailingIconColor = SqwadsTextFieldDefaults.textFieldFocusedColor()
            )
        )
    }


    
}

@Preview(showBackground = true)
@Composable
private fun EmailFieldPreview() {
    SqwadsTheme {
        SqwadsTextField(
            value = "",
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
            value = "",
            onValueChange = {},
            visualTransformation = PasswordVisualTransformation(),
            label = "Password",
            placeholder = "Enter your password"
        )
    }

}

object SqwadsTextFieldDefaults {
    @Composable
    fun textFieldUnfocusedColor() = MaterialTheme.colorScheme.secondary

    @Composable
    fun textFieldFocusedColor() = MaterialTheme.colorScheme.primary

}

