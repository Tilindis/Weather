package com.tilindis.weather.screen.locale

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tilindis.weather.utils.datastore.DataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocaleViewModel @Inject constructor(
    private val dataStore: DataStore
) : ViewModel() {
    private val _state: MutableLiveData<LocaleState> = MutableLiveData(LocaleState.empty())
    val state: LiveData<LocaleState> = _state

    init {
        viewModelScope.launch {
            getSettings()
        }
    }

    fun setAutoUpdateOn(newValue: Boolean) {
        updateState { copy(isAutoUpdateOn = newValue) }
        viewModelScope.launch {
            dataStore.setAutoUpdateValue(newValue)
        }
    }

    fun setFahrenheitOn(newValue: Boolean) {
        updateState { copy(isFahrenheitOn = newValue) }
        viewModelScope.launch {
            dataStore.setFahrenheitOn(newValue)
        }
    }

    private suspend fun getSettings() {
        dataStore.getSettings.collect {
            updateState {
                copy(
                    isAutoUpdateOn = it.autoUpdate,
                    isFahrenheitOn = it.unit
                )
            }
        }
    }

    private fun updateState(update: LocaleState.() -> LocaleState) {
        _state.value = state.value!!.update()
    }
}
