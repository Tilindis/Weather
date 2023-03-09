package com.tilindis.weather.utils.ui.card

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tilindis.weather.R

@Composable
fun DayCard(day: String, dayTemperature: String, nightTemperature: String) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RoundedCornerShape(size = 12.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier.size(32.dp),
                painter = painterResource(R.drawable.sun_day_time),
                contentDescription = "Sun of the day"
            )
            Text(text = dayTemperature)
            Spacer(modifier = Modifier.width(width = 48.dp))
            Text(text = day)
            Spacer(modifier = Modifier.width(width = 48.dp))
            Icon(
                modifier = Modifier.size(32.dp),
                painter = painterResource(R.drawable.moon_night_time),
                contentDescription = "Moon of the night"
            )
            Text(text = nightTemperature)
        }
    }
}
