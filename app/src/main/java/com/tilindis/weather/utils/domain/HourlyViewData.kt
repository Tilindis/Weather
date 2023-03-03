package com.tilindis.weather.utils.domain

data class HourlyViewData(
    val time: List<String>,
    val temperature2m: List<String>,
    val winddirection10m: List<String>,
) {
    companion object {
        private val EMPTY = HourlyViewData(listOf(), listOf(), listOf())
        fun empty() = EMPTY
    }
}