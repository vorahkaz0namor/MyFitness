package com.resonance.myfitness.presentation.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//загрузка 1 экрана и значка при открытии приложения
@Composable
fun SplashScreenLogic(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val showSplashScreen = remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        coroutineScope.launch {
            delay(2000)
            showSplashScreen.value = false
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedVisibility(visible = showSplashScreen.value) {
            SplashScreen()
        }

        AnimatedVisibility(visible = !showSplashScreen.value) {
            NavHost(navController as NavHostController, startDestination = "onboarding_1") {
                composable("onboarding_1") {
                    OnboardingScreenLogic(navController)
                }
                composable("onboarding_2") {
                    OnBoarding2(navController)
                }
                composable("onboarding_3") {
                    OnBoarding3(navController)
                }
                composable("onboarding_4") {
                    OnBoarding4(navController)
                }
            }
        }

    }
}