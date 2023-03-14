package com.tilindis.weather.utils.ui.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tilindis.weather.R

@Composable
fun EmptyArea(){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.92f)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colors.primary,
                        MaterialTheme.colors.primaryVariant
                    )
                )
            ),
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            Image(
                modifier = Modifier.size(width = 64.dp, height = 64.dp),
                painter = painterResource(id = R.drawable.bottom_bar_list),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(horizontal = 91.dp, vertical = 22.dp),
                text = stringResource(id = R.string.weather_card_data_is_empty_text),
                textAlign = TextAlign.Center
            )
        }
    }
}
