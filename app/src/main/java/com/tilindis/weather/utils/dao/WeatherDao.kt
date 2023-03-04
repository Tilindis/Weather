package com.tilindis.weather.utils.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tilindis.weather.utils.entity.HourlyEntity
import com.tilindis.weather.utils.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather")
    fun weatherFlow(): Flow<WeatherEntity>

//    @Query("SELECT * FROM hourly")
//    fun weatherHourlyFlow(): Flow<List<HourlyEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weatherEntity: WeatherEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHourlyWeather(hourly: List<HourlyEntity>)

    @Query("DELETE FROM hourly WHERE timezone = :timezone")
    suspend fun deleteHourlyCityById(timezone: String)
}
