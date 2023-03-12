package com.tilindis.weather.screen.locale

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LocaleScreen(localeViewModel: LocaleViewModel = hiltViewModel()) {
    val state: LocaleState by localeViewModel.state.observeAsState(LocaleState.empty())

    LocaleContent(
        state = state,
        onUnitClick = localeViewModel::setFahrenheitOn,
        onAutoClick = localeViewModel::setAutoUpdateOn
    )
}
