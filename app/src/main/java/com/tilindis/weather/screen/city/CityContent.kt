@file:OptIn(ExperimentalPagerApi::class)

package com.tilindis.weather.screen.city

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.tilindis.weather.R
import com.tilindis.weather.utils.domain.CityViewData
import com.tilindis.weather.utils.ui.bar.BottomBar
import com.tilindis.weather.utils.ui.card.CityCard

@Composable
fun CityContent(
    state: CityState,
    onCityClick: (String) -> Unit,
    onBack: () -> Unit,
    onUpdate: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.92f)
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.primaryVariant
                        )
                    )
                ),
            verticalArrangement = Arrangement.Center
        ) {
            CityCard(R.string.city_offline_card_name_text, state.citiesOffline, onCityClick)
            CityCard(R.string.city_card_name_text, state.cities, {})
        }
        BottomBar(
            pagerState = null,
            rightIconResource = R.drawable.bottom_bar_refresh,
            leftIconResource = R.drawable.bottom_bar_back,
            onLeftButtonClick = onBack,
            onRightButtonClick = onUpdate
        )
        Spacer(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primaryVariant)
        )
    }
}

@Composable
private fun CityCard(
    @StringRes cardName: Int,
    cities: List<CityViewData>,
    onCityClick: (String) -> Unit
) {
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
                text = stringResource(id = cardName),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            if (cardName == R.string.city_card_name_text) {
                CitiesRow(cities)
            } else {
                CitiesColumn(cities, onCityClick)
            }
        }
    }
}

@Composable
private fun CitiesColumn(
    cities: List<CityViewData>,
    onCityClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(cities) { city ->
            CityCard(
                city = city,
                onCityClick = onCityClick
            )
        }
    }
}

@Composable
private fun CitiesRow(cities: List<CityViewData>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(horizontal = 16.dp)
    ) {
        items(cities) { city ->
            CityCard(
                city = city,
                onCityClick = {}
            )
        }
    }
}
