package com.resonance.myfitness.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.resonance.myfitness.R
import com.resonance.myfitness.ui.theme.TextColorViolet

@Composable
fun SplashScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.pin_img),
                contentDescription = "Splash Screen Image",
                modifier = Modifier.size(200.dp)
            )
        }

        val coloredText = buildAnnotatedString {
            withStyle(style = SpanStyle(color = TextColorViolet, fontWeight = FontWeight.Bold)) {
                append("DDX ")
            }
            withStyle(style = SpanStyle(color = Color.Black, fontWeight = FontWeight.Bold)) {
                append("Fitness")
            }
        }

        Text(
            text = coloredText,
            fontSize = 24.sp
        )
    }
}