package com.tilindis.weather.screen.page

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PageViewModel @Inject constructor(

) : ViewModel() {
    private val _state: MutableLiveData<PageState> = MutableLiveData(PageState.empty())
    val state: LiveData<PageState> = _state

    private fun updateState(update: PageState.() -> PageState) {
        _state.value = state.value!!.update()
    }

    fun onPageButtonClick(isPageOn: Boolean) {
        updateState { copy(isPageOn = isPageOn) }
    }
}
