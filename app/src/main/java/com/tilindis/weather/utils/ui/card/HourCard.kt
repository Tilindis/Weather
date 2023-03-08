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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tilindis.weather.R

@Composable
fun HourCard(time: String?, temperature: String, windDirection: String) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(size = 12.dp)
    ) {
        Column(
            modifier = Modifier.padding(all = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (!time.isNullOrEmpty()) {
                timeData(time = time)
            }
            Text(
                text = "${temperature}°",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium
            )
            Row(
                modifier = Modifier.padding(16.dp)
            ){
                Icon(
                    modifier = Modifier.size(32.dp),
                    painter = painterResource(R.drawable.wind_indicator),
                    contentDescription = "Wind Arrow"
                )
                Spacer(modifier = Modifier.width(width = 16.dp))
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .rotate(windDirection.toFloat()),
                    painter = painterResource(R.drawable.wind_arrow),
                    contentDescription = "Wind Arrow"
                )
            }
        }
    }
}

@Composable
private fun timeData(time: String) {
    Spacer(modifier = Modifier.width(width = 8.dp))
    Text(
        text = time,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    )
}
