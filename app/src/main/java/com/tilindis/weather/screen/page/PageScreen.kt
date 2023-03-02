package com.tilindis.weather.screen.page

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tilindis.weather.screen.Screen

@Composable
fun PageScreen(
    pageViewModel: PageViewModel = hiltViewModel(),
    navController: NavController
) {
    val state: PageState by pageViewModel.state.observeAsState(PageState.empty())

    PageContent(state = state, onClick = { navigateTo(navController) })
}

private fun navigateTo(navController: NavController) {
    navController.navigate(Screen.City.route)
}
