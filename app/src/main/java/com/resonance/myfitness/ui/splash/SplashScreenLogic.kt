package com.resonance.myfitness.ui.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resonance.resources.DDXAcronym
import com.resonance.resources.R
import com.resonance.resources.TextColorViolet
import com.resonance.resources.SplashScreenIconDescription
import com.resonance.resources.SplashScreenRightPartText
import kotlinx.coroutines.delay

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}

@Preview
@Composable
fun FirstOnboardingScreenPreview() {
    FirstOnboardingScreen()
}

@Preview
@Composable
fun OtherOnboardingItemPreview() {
    OtherOnboardingItem(
        onboardingItem =
            OtherOnboardingItem
                .onboardingItems()[0],
        isLastOnboardingScreen = false
    )
}

@Preview
@Composable
fun OtherOnboardingScreenPreview() {
    OtherOnboardingScreen(
        onboardingItems = OtherOnboardingItem.onboardingItems()
    )
}

/**
 * Загрузка 1 экрана и значка при открытии приложения
 */
@Composable
fun SplashScreenLogic(navigateToAuthScreen: () -> Unit) {
    val showSplashScreen = remember { mutableStateOf(true) }
    val showFirstOnboardingItem = remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        delay(1600)
        showSplashScreen.value = false
        delay(4000)
        showFirstOnboardingItem.value = false
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(
            visible = showSplashScreen.value,
        ) { SplashScreen() }

        AnimatedVisibility(
            visible = !showSplashScreen.value,
            enter = expandHorizontally(),
            exit = fadeOut()
        ) {
            Column(
                /**
                 * TODO: When UI adaptation would be resolved then should kill this CRUTCH
                 */
                Modifier.verticalScroll(rememberScrollState())
            ) {
                if (showFirstOnboardingItem.value)
                    FirstOnboardingScreen()
                else
                    OtherOnboardingScreen(
                        onboardingItems = OtherOnboardingItem.onboardingItems(),
                        onNextButtonLastClick = navigateToAuthScreen
                    )
            }
        }
    }
}

@Composable
fun SplashScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.pin_img),
            contentDescription = SplashScreenIconDescription,
            modifier = Modifier
                .size(200.dp)
                .padding(bottom = 16.dp)
        )

        val coloredText = buildAnnotatedString {
            withStyle(style = SpanStyle(color = TextColorViolet, fontWeight = FontWeight.Bold)) {
                append(DDXAcronym)
            }
            withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                append(SplashScreenRightPartText)
            }
        }

        Text(
            text = coloredText,
            fontSize = 24.sp
        )
    }
}