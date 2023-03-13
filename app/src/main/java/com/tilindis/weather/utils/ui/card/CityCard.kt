package com.tilindis.weather.utils.ui.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tilindis.weather.R
import com.tilindis.weather.utils.domain.CityViewData
import com.tilindis.weather.utils.ui.icon.IconTemplate

@Composable
fun CityCard(
    city: CityViewData,
    onCityClick: (String) -> Unit
) {
    val iconResId =
        if (city.onScreen) R.drawable.sun_day_time else R.drawable.moon_night_time

    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .clickable { onCityClick.invoke(city.name) },
        elevation = 4.dp,
        shape = RoundedCornerShape(size = 12.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            IconTemplate(iconResource = iconResId)
            Spacer(modifier = Modifier.width(width = 48.dp))
            Text(text = city.name)
        }
    }
}