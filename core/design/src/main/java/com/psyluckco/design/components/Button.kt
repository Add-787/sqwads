/**
 * Created by developer on 26-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.design.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection.Companion.Out
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.psyluckco.design.icons.SqwadsIcons
import com.psyluckco.design.theme.SqwadsGrey
import com.psyluckco.design.theme.SqwadsTheme

@Composable
fun SqwadsButton(
    modifier : Modifier = Modifier.fillMaxWidth(),
    text : String = "Click",
    onClick: () -> Unit = { } ,
    enabled: Boolean = true
) {

    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(7.dp)
    ) {
        Text(text = text)
    }

}

@Preview
@Composable
fun SqwadsButtonPreview() {
    SqwadsTheme {
        SqwadsButton()
    }
}

@Composable
fun SqwadsOutlinedIconButton(
    modifier: Modifier = Modifier,
    onClick : () -> Unit = {},
    content: @Composable () -> Unit
) {

    OutlinedButton(
        onClick = { /*TODO*/ },
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(0.5.dp, SqwadsGrey),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.Black
        )
    ) {
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun SqwadsOutlinedIconPreview() {
    SqwadsTheme {
        SqwadsOutlinedIconButton {
            Icon(imageVector = SqwadsIcons.PlaceHolder, contentDescription = null)
        }
    }
    
}

object SqwadsButtonDefaults {
    @Composable
    fun buttonContainerColor() = MaterialTheme.colorScheme.background


}







