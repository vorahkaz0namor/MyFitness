package com.resonance.myfitness.splashScreen

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.resonance.myfitness.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@SuppressLint("ComposableNaming")
@Composable
fun OnboardingScreenLogic(navController: NavController): MutableState<Boolean> {
    val coroutineScope = rememberCoroutineScope()
    val showOnboardingScreen = remember { mutableStateOf(true) }

    // Проверяем, было ли приложение запущено ранее
    val sharedPreferences =
        LocalContext.current.getSharedPreferences("myAppPreferences", Context.MODE_PRIVATE)
    val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)

    if (isFirstRun) {
        LaunchedEffect(true) {
            coroutineScope.launch {
                delay(2000)
                // Сохраняем информацию о том, что Onboarding был показан
                sharedPreferences.edit().putBoolean("isFirstRun", false).apply()
                showOnboardingScreen.value = false
            }
        }
    } else {
        showOnboardingScreen.value = false
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (showOnboardingScreen.value) {
            Image(
                painter = painterResource(id = R.drawable.onboarding_welcome_screen_img),
                contentDescription = "Onboarding Image",
                modifier = Modifier
                    .fillMaxSize() // Заполняем размер изображения на весь экран
                    .clickable { showOnboardingScreen.value = false
                        navController.navigate("onboarding_2")},
                contentScale = ContentScale.FillBounds // Заполнить размер изображения, сохраняя пропорции
            )
        }  else {
            Image(
                painter = painterResource(id = R.drawable.onboarding_welcome_screen_img),
                contentDescription = "Onboarding Image",
                modifier = Modifier
                    .fillMaxSize() // Заполняем размер изображения на весь экран
                    .clickable { showOnboardingScreen.value = false
                    navController.navigate("onboarding_2")},
                contentScale = ContentScale.FillBounds // Заполнить размер изображения, сохраняя пропорции
            )
        }

    }
    return showOnboardingScreen
}