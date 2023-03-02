package com.tilindis.weather.screen.locale

import androidx.compose.runtime.Composable

@Composable
fun LocaleContent(state: LocaleState) {
    println(state.autoUpdate)
}
