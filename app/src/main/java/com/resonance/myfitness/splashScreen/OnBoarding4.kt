package com.resonance.myfitness.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.draw.clip
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
fun OnBoarding4(navController: NavController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.onboarding4_img),
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
                                append("Давайте заниматься\n спортом и вести здоровый\n образ жизни вместе с ")
                            }
                            withStyle(style = SpanStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold, color = TextColorViolet)) {
                                append("DDX")
                            }
                            withStyle(style = SpanStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold)) {
                                append("!")
                            }
                        },
                        color = Color.Black,
                        fontSize = 18.sp,
                        textAlign = TextAlign.Center
                    )

                }
            }

            SliderWithIndicator(currentPage = 3, modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp)) // Индикатор слайдера


            Button(
                onClick = { navController.navigate("onboarding_1"){
                    popUpTo("onboarding_1"){
                        inclusive = true
                    }
                } },
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 12.dp)
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        color = TextColorViolet,
                        shape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp, bottomStart = 12.dp, bottomEnd =12.dp)
                    )
            ) {
                Text(text = "Далее", color = Color.White)
            }

        }
    }
}