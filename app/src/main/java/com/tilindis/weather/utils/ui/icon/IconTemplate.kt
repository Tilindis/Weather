package com.tilindis.weather.utils.ui.icon

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconTemplate(
    @DrawableRes iconResource: Int,
    rotation: String?
){
    val modifier = if(rotation != null) {
        Modifier
            .size(32.dp)
            .rotate(rotation.toFloat())
    } else {
        Modifier.size(32.dp)
    }

    Icon(
        modifier = modifier,
        painter = painterResource(iconResource),
        contentDescription = "Icon template"
    )
}
