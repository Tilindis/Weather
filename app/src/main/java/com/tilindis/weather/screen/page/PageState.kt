package com.tilindis.weather.screen.page

import com.tilindis.weather.BuildConfig

data class PageState(
    val appVersion: String,
    val isPageOn: Boolean
) {
    companion object {
        private val EMPTY = PageState(appVersion = BuildConfig.VERSION_NAME, isPageOn = false)

        fun empty() = EMPTY
    }
}
