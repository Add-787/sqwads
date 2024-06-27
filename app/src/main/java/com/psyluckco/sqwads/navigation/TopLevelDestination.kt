package com.psyluckco.sqwads.navigation

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.psyluckco.design.icons.SqwadsIcons
import com.psyluckco.feature.lineups.R as lineupsR
import com.psyluckco.sqwads.R

enum class TopLevelDestination(
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val iconTextId : Int
) {

    LINEUPS(
        selectedIcon = SqwadsIcons.PlaceHolder,
        unselectedIcon = SqwadsIcons.PlaceHolderOutlined,
        iconTextId = lineupsR.string.feature_lineups_title
    ),
    AUCTIONS(
        selectedIcon = SqwadsIcons.PlaceHolder,
        unselectedIcon = SqwadsIcons.PlaceHolderOutlined,
        iconTextId = lineupsR.string.feature_lineups_title
    ),
    PROFILE(
        selectedIcon = SqwadsIcons.PlaceHolder,
        unselectedIcon = SqwadsIcons.PlaceHolderOutlined,
        iconTextId = lineupsR.string.feature_lineups_title
    )

}