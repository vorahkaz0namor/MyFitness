package com.resonance.myfitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.navigation.compose.rememberNavController
import com.resonance.myfitness.splashScreen.OnBoarding2
import com.resonance.myfitness.splashScreen.OnBoarding3
import com.resonance.myfitness.splashScreen.OnBoarding4
import com.resonance.myfitness.splashScreen.OnboardingScreenLogic
import com.resonance.myfitness.splashScreen.SplashScreen
import com.resonance.myfitness.ui.theme.MyFitnessTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFitnessTheme {
                navController = rememberNavController()
                SplashScreenLogic(navController)
            }
        }
    }

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

}