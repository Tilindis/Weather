package com.tilindis.weather.utils.di

import android.app.Application
import com.tilindis.weather.utils.api.WeatherService
import com.tilindis.weather.utils.dao.WeatherDao
import com.tilindis.weather.utils.format.DateFormatter
import com.tilindis.weather.utils.repository.WeatherRepository
import com.tilindis.weather.utils.room.AppDatabase
import com.tilindis.weather.utils.usecase.WeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {
    @Singleton
    @Provides
    fun provideAppDatabase(app: Application): AppDatabase {
        return AppDatabase.getInstance(app)
    }

    @Singleton
    @Provides
    fun provideWeatherDao(appDatabase: AppDatabase): WeatherDao {
        return appDatabase.weatherDao()
    }
    @Singleton
    @Provides
    fun provideRepository(
        apiService: WeatherService,
        weatherDao: WeatherDao,
        dateFormatter: DateFormatter
    ) = WeatherRepository(apiService, weatherDao, dateFormatter)

    @Singleton
    @Provides
    fun provideWeatherUseCase(
        weatherRepository: WeatherRepository
    ) = WeatherUseCase(weatherRepository)
}
