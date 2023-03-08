package com.tilindis.weather.screen.page

import com.tilindis.weather.utils.domain.WeatherViewData

data class PageState(
    val isPageOn: Boolean,
    val weatherData: List<WeatherViewData> = emptyList()
) {
    companion object {
        private val EMPTY = PageState(
            isPageOn = false,
            weatherData = emptyList()
        )

        fun empty() = EMPTY
    }
}
