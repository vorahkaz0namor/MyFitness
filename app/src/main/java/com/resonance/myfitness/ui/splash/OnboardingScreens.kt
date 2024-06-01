package com.resonance.myfitness.ui.splash

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resonance.resources.DDXAcronym
import com.resonance.resources.ExclamationPoint
import com.resonance.resources.FirstOnboardingImage
import com.resonance.resources.NextButtonCaption
import com.resonance.resources.OtherOnboardingImage
import com.resonance.resources.OtherOnboardingLatinCaption
import com.resonance.resources.OtherOnboardingThirdCaptionTwo
import com.resonance.resources.R
import com.resonance.resources.TextColorGray
import com.resonance.resources.TextColorViolet

@Composable
fun FirstOnboardingScreen() {
    Image(
        painter = painterResource(id = R.drawable.onboarding_welcome_screen_img),
        contentDescription = FirstOnboardingImage,
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OtherOnboardingScreen(
    onboardingItems: List<OtherOnboardingItem>,
    onNextButtonLastClick: () -> Unit = {}
) {
    val pagerState = rememberPagerState(
        pageCount = { onboardingItems.size }
    )
    val currentPageIndex by remember {
        derivedStateOf { pagerState.currentPage }
    }
    val shouldScrollPager = rememberSaveable {
        mutableStateOf(false)
    }
    val setShouldScrollPagerTrue = {
        shouldScrollPager.value = true
    }

    if (shouldScrollPager.value)
        LaunchedEffect(key1 = null) {
            pagerState.scrollToPage(currentPageIndex + 1)
            shouldScrollPager.value = false
        }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HorizontalPager(
            modifier = Modifier.wrapContentSize(),
            state = pagerState,
            pageSize = PageSize.Fill
        ) { pageIndex ->
            OtherOnboardingItem(
                onboardingItem = onboardingItems[pageIndex],
                isLastOnboardingScreen = pageIndex == onboardingItems.lastIndex
            )
        }

        SliderWithIndicator(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 12.dp
                ),
            currentPageIndex = currentPageIndex,
            onboardingItemsIndexes = List(onboardingItems.size) { it }
        )

        /**
         * Кнопка "Далее" для перехода к следующему экрану
         */

        /**
         * Кнопка "Далее" для перехода к следующему экрану
         */
        Button(
            onClick =
            if (currentPageIndex == onboardingItems.lastIndex)
                onNextButtonLastClick
            else
                setShouldScrollPagerTrue,
            shape = RoundedCornerShape(size = 12.dp),
            modifier = Modifier
                .padding(all = 12.dp)
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                TextColorViolet
            )
        ) {
            Text(
                text = NextButtonCaption,
                color = Color.White
            )
        }
    }
}
@Composable
fun OtherOnboardingItem(
    onboardingItem: OtherOnboardingItem,
    isLastOnboardingScreen: Boolean
) {
    Column(modifier = Modifier.wrapContentSize()) {
        Image(
            painter = painterResource(id = onboardingItem.image),
            modifier = Modifier.fillMaxWidth(),
            contentDescription = OtherOnboardingImage,
            alignment = Alignment.TopCenter,
            contentScale = ContentScale.FillWidth,
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-16).dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp
                    )
                )
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontSize = if (isLastOnboardingScreen) 23.sp else 24.sp,
                            )
                        ) { append(onboardingItem.caption) }
                        if (isLastOnboardingScreen) {
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 23.sp,
                                    color = TextColorViolet
                                )
                            ) { append(DDXAcronym) }
                            withStyle(
                                style = SpanStyle(
                                    fontSize = 23.sp,
                                )
                            ) { append(ExclamationPoint) }
                        }
                    },
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text =
                    if (onboardingItem.showLatinCaption)
                        OtherOnboardingLatinCaption
                    else
                        OtherOnboardingThirdCaptionTwo
                    ,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = TextColorGray,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}