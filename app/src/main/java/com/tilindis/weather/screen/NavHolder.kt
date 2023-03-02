@file:OptIn(ExperimentalAnimationApi::class, ExperimentalAnimationApi::class)

package com.tilindis.weather.screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.tilindis.weather.screen.city.CityScreen
import com.tilindis.weather.screen.locale.LocaleScreen
import com.tilindis.weather.screen.page.PageScreen
import com.tilindis.weather.ui.theme.WeatherTheme

@Composable
fun NavHolder(){
    val navController = rememberAnimatedNavController()

    WeatherTheme {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            AnimatedNavHost(
                navController = navController,
                startDestination = Screen.Page.route
            ) {
                composable(Screen.Page.route) { PageScreen(navController = navController) }
                composable(Screen.City.route) { CityScreen(navController = navController) }
                composable(Screen.Locale.route) { LocaleScreen() }
            }
        }
    }
}
