package com.tilindis.weather.screen.locale

data class LocaleState(
    val isAutoUpdateOn: Boolean,
    val isFahrenheitOn: Boolean
) {
    companion object {
        private val EMPTY = LocaleState(isAutoUpdateOn = false, isFahrenheitOn = false)

        fun empty() = EMPTY
    }
}
