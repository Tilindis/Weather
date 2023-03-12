package com.tilindis.weather.screen.city

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.tilindis.weather.R
import com.tilindis.weather.utils.ui.card.CityCard
import com.tilindis.weather.utils.ui.card.DayCard

@Composable
fun CityContent(
    state: CityState,
    onCityClick: (String) -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize())
    {
        Card(
            modifier = Modifier
                .wrapContentSize()
                .padding(4.dp),
            shape = RoundedCornerShape(size = 12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .padding(4.dp),
                    text = stringResource(R.string.city_card_name_text),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(state.cities) { city ->
                        CityCard(
                            city = city,
                            onCityClick = onCityClick
                        )
                    }
                }
            }
        }
    }
}
