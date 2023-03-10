package com.tilindis.weather.utils.calculation

import com.tilindis.weather.utils.domain.HourlyViewData
import com.tilindis.weather.utils.domain.WeekViewData
import com.tilindis.weather.utils.format.DateFormatter
import kotlin.math.roundToInt

class TemperatureCalculation() {
    fun calculateAverageWeekTemperature(hourlyData: List<HourlyViewData>): List<WeekViewData> {
        var dayAverageTemp = 0.0
        var nightAverageTemp = 0.0

        val dayNightTemps = mutableListOf<WeekViewData>()

        for (dateTimeStr in hourlyData) {
            val hourOfDay = DateFormatter().getOnlyHour(dateTimeStr.time).toInt()
            val dayName = DateFormatter().getDayName(dateTimeStr.time)
            if (hourOfDay in 6..17) {
                dayAverageTemp += dateTimeStr.temperature2m.toDouble()
            } else {
                nightAverageTemp += dateTimeStr.temperature2m.toDouble()
            }

            if (hourOfDay == 23) {
                val avgDayTemp = dayAverageTemp / 12
                val avgNightTemp = nightAverageTemp / 12
                dayNightTemps.add(
                    WeekViewData(
                        dayName,
                        avgDayTemp.roundToInt(),
                        avgNightTemp.roundToInt()
                    )
                )
                dayAverageTemp = 0.0
                nightAverageTemp = 0.0
            }
        }
        return dayNightTemps
    }
}
