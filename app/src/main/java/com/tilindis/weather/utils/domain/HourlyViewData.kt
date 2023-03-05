package com.tilindis.weather.utils.domain

data class HourlyViewData(
    val id: Int,
    val timezone: String,
    val time: String,
    val temperature2m: String,
    val winddirection10m: String,
) {
    companion object {
        private val EMPTY = HourlyViewData(0, "", "", "", "")
        fun empty() = EMPTY
    }
}
