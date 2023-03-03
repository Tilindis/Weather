package com.tilindis.weather.utils.di

import com.tilindis.weather.utils.api.WeatherService
import com.tilindis.weather.utils.repository.WeatherRepository
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
    fun provideRepository(
        apiService: WeatherService,
    ) = WeatherRepository(apiService)

    @Singleton
    @Provides
    fun provideWeatherUseCase(
        weatherRepository: WeatherRepository
    ) = WeatherUseCase(weatherRepository)
}
