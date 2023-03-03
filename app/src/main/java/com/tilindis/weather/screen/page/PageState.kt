package com.tilindis.weather.screen.page

import com.tilindis.weather.utils.domain.WeatherViewData

data class PageState(
    val isPageOn: Boolean,
    val weatherData: WeatherViewData
) {
    companion object {
        private val EMPTY = PageState(
            isPageOn = false,
            weatherData = WeatherViewData.empty()
        )

        fun empty() = EMPTY
    }
}
