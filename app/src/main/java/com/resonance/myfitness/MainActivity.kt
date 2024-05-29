package com.resonance.myfitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.resonance.myfitness.presentation.view.SplashScreenLogic
import com.resonance.myfitness.ui.theme.MyFitnessTheme

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
}