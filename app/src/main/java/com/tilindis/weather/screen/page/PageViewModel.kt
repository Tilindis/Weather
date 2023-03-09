package com.tilindis.weather.screen.page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilindis.weather.utils.usecase.WeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PageViewModel @Inject constructor(
    private val weatherUseCase: WeatherUseCase
) : ViewModel() {
    private val _state: MutableLiveData<PageState> = MutableLiveData(PageState.empty())
    val state: LiveData<PageState> = _state

    init {
        viewModelScope.launch {
            //weatherUseCase.loadWeather()
            loadCurrentWeatherData()
        }
    }

    private suspend fun loadCurrentWeatherData(){
        weatherUseCase.weatherFlow.collect {
            updateState { copy(weatherData = it.map { page -> page.toWeatherViewData() }) }
            loadHourlyData()
        }
    }

    private suspend fun loadHourlyData(){
        weatherUseCase.weatherHourlyFlow.collect{
            updateState { copy(hourlyData = it.map { hour -> hour.toHourlyViewData()}) }
        }
    }

    private fun updateState(update: PageState.() -> PageState) {
        _state.value = state.value!!.update()
    }

    fun onPageButtonClick(isPageOn: Boolean) {
        updateState { copy(isPageOn = isPageOn) }
    }
}
