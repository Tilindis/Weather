package com.tilindis.weather.utils.ui.icon

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconTemplate(
    @DrawableRes iconResource: Int
){
    Icon(
        modifier = Modifier.size(32.dp),
        painter = painterResource(iconResource),
        contentDescription = "Icon template"
    )
}
