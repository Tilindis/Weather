package com.tilindis.weather.screen.page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilindis.weather.utils.datastore.DataStore
import com.tilindis.weather.utils.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.roundToInt

@HiltViewModel
class PageViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase,
    private val dataStore: DataStore
) : ViewModel() {
    private val _state: MutableLiveData<PageState> = MutableLiveData(PageState.empty())
    val state: LiveData<PageState> = _state

    init {
        onRefresh()
    }

    fun onRefresh(){
        viewModelScope.launch {
            getSettings()
        }
    }

    private suspend fun getSettings() {
        dataStore.getSettings.collect {
            updateState {
                copy(isAutoUpdateOn = it.autoUpdate, isFahrenheitOn = it.unit)
            }
            loadCurrentWeatherData()
        }
    }

    private suspend fun autoUpdateDataBase() {
        if (state.value?.isAutoUpdateOn == true && state.value?.isAutoUpdated == false) {
            weatherUseCase.autoUpdateCities(state.value?.weatherData)
            updateState { copy(isAutoUpdated = true) }
            loadCurrentWeatherData()
        }
    }

    private suspend fun loadCurrentWeatherData() {
        weatherUseCase.weatherFlow.collect {
            val weatherData = it.map { page -> page.toWeatherViewData() }
            val convertedData = if (state.value?.isFahrenheitOn == true) {
                weatherData.map { it.copy(temperature = toFahrenheit(it.temperature)) }
            } else {
                weatherData
            }
            updateState { copy(weatherData = convertedData) }

            autoUpdateDataBase()

            loadHourlyData()
        }
    }

    private suspend fun loadHourlyData() {
        weatherUseCase.weatherHourlyFlow.collect {
            val hourlyData = it.map { hour -> hour.toHourlyViewData() }
            val convertedData = if (state.value?.isFahrenheitOn == true) {
                hourlyData.map { it.copy(temperature2m = toFahrenheit(it.temperature2m)) }
            } else {
                hourlyData
            }
            updateState { copy(hourlyData = convertedData) }
        }
    }

    private fun updateState(update: PageState.() -> PageState) {
        _state.value = state.value!!.update()
    }

    private fun toFahrenheit(temperature: String): String {
        return (temperature.toDouble() * 1.8 + 32).roundToInt().toString()
    }
}
