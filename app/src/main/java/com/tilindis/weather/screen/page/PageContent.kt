package com.tilindis.weather.screen.page

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun PageContent(
    state: PageState,
    onPageButtonClick: () -> Unit
) {
    Text(text = state.appVersion, color = Color.Red)
}
