package com.tilindis.weather.utils.format

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class DateFormatter @Inject constructor() {
    private val hourFormatter = SimpleDateFormat("HH:mm")
    private val dateFormatter = SimpleDateFormat("yyyy-MM-dd")
    private val fullDateFormatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())

    fun getOnlyHour(date: String): String {
        return date.split("T")[1].split(":")[0]
    }

    fun getDayName(dateString: String): String {
        val dateFormat: DateFormat = fullDateFormatter
        val calendar: Calendar = Calendar.getInstance()
        try {
            dateFormat.parse(dateString)?.let { calendar.time = it }
            return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())
                .orEmpty()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }

    fun getCurrentTime(): String{
        return hourFormatter.format(Calendar.getInstance().time)
    }

    fun getCurrentDate(): String{
        return dateFormatter.format(Calendar.getInstance().time)
    }
}
