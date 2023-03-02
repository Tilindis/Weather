package com.tilindis.weather.screen.locale

data class LocaleState(
    val autoUpdate: Boolean
){
    companion object {
        private val EMPTY = LocaleState(autoUpdate = false)

        fun empty() = EMPTY
    }
}
