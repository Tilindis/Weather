package com.tilindis.weather.screen.page

import com.tilindis.weather.BuildConfig
import com.tilindis.weather.utils.domain.WeatherViewData

data class PageState(
    val appVersion: String,
    val isPageOn: Boolean,
    val weatherData: WeatherViewData
) {
    companion object {
        private val EMPTY = PageState(
            appVersion = BuildConfig.VERSION_NAME,
            isPageOn = false,
            weatherData = WeatherViewData.empty()
        )

        fun empty() = EMPTY
    }
}
