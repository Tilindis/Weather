@file:OptIn(ExperimentalMaterialApi::class)

package com.tilindis.weather.screen.page

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.tilindis.weather.screen.Screen
import com.tilindis.weather.screen.locale.LocaleScreen
import kotlinx.coroutines.launch

@Composable
fun PageScreen(
    pageViewModel: PageViewModel = hiltViewModel(),
    navController: NavController
) {
    val state: PageState by pageViewModel.state.observeAsState(PageState.empty())

    val sheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed
    )
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        modifier =
        Modifier.pointerInput(Unit) {
            detectTapGestures(onTap = {
                scope.launch {
                    if (scaffoldState.bottomSheetState.isCollapsed) {
                        scaffoldState.bottomSheetState.expand()
                    } else {
                        scaffoldState.bottomSheetState.collapse()
                        pageViewModel.onRefresh()
                    }
                }
            })
        },
        scaffoldState = scaffoldState,
        sheetBackgroundColor = Color.Black,
        sheetShape = RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp),
        sheetPeekHeight = 0.dp,
        sheetContent = {
            LocaleScreen()
        }
    ) {
        PageContent(
            state = state,
            onCityClick = { navigateTo(navController) },
            onLocaleClick = { scope.launch { sheetState.expand() } },
        )
    }
}

private fun navigateTo(navController: NavController) {
    navController.navigate(Screen.City.route)
}
