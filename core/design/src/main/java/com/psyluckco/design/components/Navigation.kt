/**
 * Created by developer on 26-06-2024.
 * Tismo Technology Solutions (P) Ltd.
 * developers@tismotech.net
 */

package com.psyluckco.design.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.psyluckco.design.icons.SqwadsIcons
import com.psyluckco.design.theme.SqwadsTheme

@Composable
fun RowScope.SqwadsNavigationBarItem(
    selected: Boolean = false,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    alwaysShowLabel: Boolean = true,
    label: @Composable (() -> Unit)? = { Text("Item") },
    icon: @Composable () -> Unit = { Icon(SqwadsIcons.PlaceHolder, contentDescription = null) }
) {

    NavigationBarItem(
        modifier = modifier,
        selected = selected,
        onClick = onClick,
        icon = icon,
        alwaysShowLabel = alwaysShowLabel,
        label = label,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = SqwadsNavigationDefaults.navigationSelectedColor(),
            indicatorColor = MaterialTheme.colorScheme.background,
            unselectedIconColor = SqwadsNavigationDefaults.navigationUnselectedColor()
        )
    )

    
}

@Composable
fun SqwadsNavigationBar(
    modifier : Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 21.dp
        ),
        shape = RectangleShape
    ) {
        NavigationBar(
            modifier = modifier,
            tonalElevation = 0.dp,
            content = content,
            containerColor = SqwadsNavigationDefaults.navigationContainerColor()
        )
    }


}


@Preview
@Composable
private fun SqwadsNavigationBarPreview() {

    val items = listOf("Auctions","Lineups","Info")

    SqwadsTheme {
        SqwadsNavigationBar {
            SqwadsNavigationBarItem(selected = true, onClick = { /*TODO*/ })
            SqwadsNavigationBarItem(onClick = { /*TODO*/ })
            SqwadsNavigationBarItem(onClick = { /*TODO*/ })
            SqwadsNavigationBarItem(onClick = { /*TODO*/ })
        }
    }

}

object SqwadsNavigationDefaults {
    @Composable
    fun navigationContainerColor() = MaterialTheme.colorScheme.background

    @Composable
    fun navigationSelectedColor() = MaterialTheme.colorScheme.onBackground

    @Composable
    fun navigationUnselectedColor() = MaterialTheme.colorScheme.secondary


}