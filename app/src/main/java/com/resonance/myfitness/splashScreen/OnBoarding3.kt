package com.resonance.myfitness.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.resonance.myfitness.R
import com.resonance.myfitness.ui.theme.TextColorViolet

@Composable
fun OnBoarding3(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboarding3_img),
                contentDescription = "Your Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(585.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(Color.White)
                    .offset(y = (-16).dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .background(Color.White, shape = RoundedCornerShape(16.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold)) {
                                append("Тренируйтесь и\n получайте отличные\n результаты.")

                            }
                        },
                        color = Color.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
            SliderWithIndicator(currentPage = 2, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) // Индикатор слайдера
            Spacer(modifier = Modifier.height(12.dp))

            Button(
                onClick = { navController.navigate("onboarding_4") },
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        color = TextColorViolet,
                        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomStart = 12.dp, bottomEnd =12.dp)
                    ),
                colors = ButtonDefaults.buttonColors(
                    TextColorViolet
                )
            ) {
                Text(text = "Далее", color = Color.White)
            }
        }
    }
}