package com.tilindis.weather.utils.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tilindis.weather.utils.domain.HourlyViewData

@Entity(tableName = "hourly")
data class HourlyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "timezone") val timezone: String,
    @ColumnInfo(name = "time") val time: String,
    @ColumnInfo(name = "temperature2m") val temperature2m: String,
    @ColumnInfo(name = "winddirection10m") val winddirection10m: String
){
    companion object {
        private val EMPTY = HourlyEntity(
            id = 0,
            timezone = "",
            time = "",
            temperature2m = "",
            winddirection10m = ""
        )
        fun empty() = EMPTY
    }

    fun toHourlyViewData(): HourlyViewData {
        return HourlyViewData(
            id = id ?: 0,
            timezone = timezone,
            time = time,
            temperature2m = temperature2m,
            winddirection10m = winddirection10m
        )
    }
}
