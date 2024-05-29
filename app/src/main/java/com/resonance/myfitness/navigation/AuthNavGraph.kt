package com.resonance.myfitness.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.resonance.myfitness.presentation.view.SplashScreenLogic
import com.resonance.myfitness.ui.auth.AuthStubScreen

fun NavGraphBuilder.authNavGraph(rootNavController: NavHostController) {
    navigation(
        route = Graph.AUTH,
        startDestination = AuthScreen.Splash.route
    ) {
        composable(route = AuthScreen.Splash.route) {
//            AuthStubScreen()
            SplashScreenLogic(navController = rootNavController)
        }
        composable(route = AuthScreen.Onboarding.route) {

        }
        composable(route = AuthScreen.Welcome.route) {

        }
        composable(route = AuthScreen.Login.route) {

        }
    }
}

sealed class AuthScreen(val route: String) {
    companion object {
        const val SPLASH_SCREEN = "splash_screen"
        const val ONBOARDING_SCREEN = "onboarding_screen"
        const val WELCOME_SCREEN = "welcome_screen"
        const val LOGIN_SCREEN = "login_screen"
    }
    data object Splash: AuthScreen(SPLASH_SCREEN)
    data object Onboarding: AuthScreen(ONBOARDING_SCREEN)
    data object Welcome: AuthScreen(WELCOME_SCREEN)
    data object Login: AuthScreen(LOGIN_SCREEN)
}