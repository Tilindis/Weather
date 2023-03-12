package com.tilindis.weather.screen.locale

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tilindis.weather.R

@Composable
fun LocaleContent(
    state: LocaleState,
    onAutoClick: (Boolean) -> Unit,
    onUnitClick: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = state.isAutoUpdateOn.toString(),
            fontSize = 60.sp
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ValueEnableSection(
            isValueOn = state.isFahrenheitOn,
            valueText = "Far",
            onValueButtonClick = onUnitClick
        )
        ValueEnableSection(
            isValueOn = state.isAutoUpdateOn,
            valueText = "Auto",
            onValueButtonClick = onAutoClick
        )
    }
}

@Composable
private fun ValueEnableSection(
    isValueOn: Boolean,
    valueText: String,
    onValueButtonClick: (Boolean) -> Unit
) {
    val iconResId =
        if (isValueOn) R.drawable.check_circle else R.drawable.check_circle_outline

    Row(
        modifier = Modifier.padding(start = 22.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { onValueButtonClick.invoke(!isValueOn) }) {
            Icon(
                modifier = Modifier.size(18.dp),
                painter = painterResource(id = iconResId),
                contentDescription = null,
                tint = MaterialTheme.colors.surface,
            )
        }
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = valueText,
            color = Color.Black
        )
    }
}
