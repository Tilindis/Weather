package com.tilindis.weather.screen.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PageScreen(pageViewModel: PageViewModel = hiltViewModel()) {
    val state: PageState by pageViewModel.state.observeAsState(PageState.empty())

    PageContent(state = state, {})
}
