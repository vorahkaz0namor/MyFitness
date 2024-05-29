package com.resonance.myfitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.resonance.myfitness.navigation.RootNavGraph
import com.resonance.resources.MyFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyFitnessTheme {
                RootNavGraph(navController = rememberNavController())
            }
        }
    }
}