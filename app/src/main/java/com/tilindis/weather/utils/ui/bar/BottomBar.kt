@file:OptIn(ExperimentalPagerApi::class)

package com.tilindis.weather.utils.ui.bar

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState

@Composable
fun BottomBar(
    pagerState: PagerState?,
    @DrawableRes rightIconResource: Int,
    @DrawableRes leftIconResource: Int,
    onRightButtonClick: () -> Unit,
    onLeftButtonClick: () -> Unit,

) {
    Row(
        modifier = Modifier
            .background(color = MaterialTheme.colors.primaryVariant)
            .fillMaxWidth()
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            IconButton(onClick = onLeftButtonClick) {
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = leftIconResource),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
        Box(
            modifier = Modifier
                .weight(4f)
        ) {
            if(pagerState != null){
                HorizontalPagerIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    pagerState = pagerState,
                    activeColor = Color.Black,
                    indicatorWidth = 8.dp,
                    inactiveColor = Color.White,
                )
            }
        }
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ) {
            IconButton(onClick = onRightButtonClick) {
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.Center),
                    painter = painterResource(id = rightIconResource),
                    contentDescription = null,
                    tint = Color.Black
                )
            }
        }
    }
}
